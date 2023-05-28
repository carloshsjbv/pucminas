package br.com.pucminas.reports;

import br.com.pucminas.user.entity.EnumStatus;
import br.com.pucminas.user.entity.UserEntity;
import br.com.pucminas.user.service.UserService;
import br.com.pucminas.workouts.entity.ExerciseEntity;
import br.com.pucminas.workouts.entity.WorkoutDayEntity;
import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import br.com.pucminas.workouts.service.WorkoutPlanService;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static br.com.pucminas.reports.DueWorkoutCronJob.TRAINEE_USER_TYPE_ID;

@Slf4j
@Component
public class SendExerciseCronJob {

    public static final String SUBJECT_MESSAGE = "Seu treino chegou!";

    public static final String MESSAGE_BODY = "Ola, %s <br/>" +
            "Seu personal trainer %s enviou seu treino via plataforma MeFit App.<br/>" +
            "<br/><br/>" +
            "Bons Treinos!" +
            "<br/><br/>" +
            "Time Me-fit App";
    public static final String DOCUMENT_HEADER = "ME FIT APP";
    public static final String DEFAULT_BLUE_COLOR = "#1A6EED";
    public static final String LIGHT_BLUE_COLOR = "#E8F0FD";
    public static final String HEADER_WORKOUT_PERIOD_PHRASE = "Plano de treinamento referente ao período %s - %s";

    private final WorkoutPlanService workoutPlanService;

    private final UserService userService;

    private final EmailSender emailSender;

    public SendExerciseCronJob(
            final WorkoutPlanService workoutPlanService,
            final UserService userService,
            final EmailSender emailSender
    ) {
        this.workoutPlanService = workoutPlanService;
        this.userService = userService;
        this.emailSender = emailSender;
    }

    @Async
    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.MINUTES)
    public void sendExercisesJob() {

        log.info("Send exercise JOB has started at - {} ", LocalDateTime.now());

        final List<WorkoutPlanEntity> workoutPlans = workoutPlanService.findAllBySent(false);

        if (!workoutPlans.isEmpty()) {

            final List<UserEntity> users = userService.findUsersByStatusAndUserTypeId(EnumStatus.ACTIVE, TRAINEE_USER_TYPE_ID);

            final Map<Long, UserEntity> userMap = users.stream().collect(Collectors.toMap(UserEntity::getId, Function.identity()));

            if (!userMap.isEmpty()) {

                workoutPlans.forEach(workoutPlan -> {

                    Path filePath;
                    try {
                        filePath = generateWorkoutPlanPdf(workoutPlan);
                    } catch (IOException e) {
                        log.error("Error while creating PDF file.");
                        throw new RuntimeException(e);
                    }

                    sendEmail(userMap, workoutPlan, filePath.toFile());

                    workoutPlan.setSent(true);

                    // update right after it is sent
                    workoutPlanService.updateWorkoutPlan(workoutPlan);
                });

            }
        }

        log.info("Send exercise JOB has ended at - {} ", LocalDateTime.now());

    }

    private static Path generateWorkoutPlanPdf(final WorkoutPlanEntity workoutPlanEntity) throws IOException {

        final Path tempPdf = Files.createTempFile(UUID.randomUUID().toString(), ".pdf");

        final PdfWriter writer = new PdfWriter(tempPdf.toFile());

        final PdfDocument pdf = new PdfDocument(writer);

        final Document document = new Document(pdf);

        document.getPageEffectiveArea(PageSize.A4);

        final Paragraph headerMeFit = new Paragraph(DOCUMENT_HEADER)
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(30)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setStrokeColor(WebColors.getRGBColor(DEFAULT_BLUE_COLOR));

        document.add(headerMeFit);

        final Paragraph headerParagraph = new Paragraph(String.format(HEADER_WORKOUT_PERIOD_PHRASE, workoutPlanEntity.getStartDate(), workoutPlanEntity.getEndDate()))
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setTextAlignment(TextAlignment.CENTER);

        document.add(headerParagraph);


        for (WorkoutDayEntity workoutDay : workoutPlanEntity.getWorkoutDayEntities()) {

            final String muscularGroup = String.join(" e ", new ArrayList<>(workoutDay.getExercises())
                    .stream()
                    .map(exercise -> exercise.getMuscularGroup().name())
                    .distinct()
                    .collect(Collectors.toList()));

            final String tableHeaderText = (workoutDay.getWeekDay() + " - " + muscularGroup).toUpperCase();

            final Paragraph tableHeaderParagraph = new Paragraph(tableHeaderText)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginBottom(8);

            final Cell tableHeader = new Cell(1, 2)
                    .add(tableHeaderParagraph)
                    .setBackgroundColor(WebColors.getRGBColor(DEFAULT_BLUE_COLOR));

            final Table table = new Table(new float[]{2, 100})
                    .setMarginTop(30)
                    .setWidth(450)
                    .addHeaderCell(tableHeader)
                    .setHorizontalAlignment(HorizontalAlignment.CENTER);

            int rowCount = table.getNumberOfRows();

            for (ExerciseEntity exercise : workoutDay.getExercises()) {

                final Paragraph exerciseName = new Paragraph(exercise.getName())
                        .setTextAlignment(TextAlignment.LEFT);

                table.addCell(exerciseName);

                table.addCell(workoutPlanEntity.getSeries() + " x " + workoutPlanEntity.getReps())
                        .setTextAlignment(TextAlignment.CENTER);

                if ((rowCount % 2) == 0) {

                    table.getCell(rowCount, 0)
                            .setBackgroundColor(WebColors.getRGBColor(LIGHT_BLUE_COLOR));
                    table.getCell(rowCount, 1)
                            .setBackgroundColor(WebColors.getRGBColor(LIGHT_BLUE_COLOR));

                }
                rowCount++;

            }

            document.add(table);
        }


        document.close();

        return tempPdf;
    }

    private void sendEmail(final Map<Long, UserEntity> userMap, final WorkoutPlanEntity workoutPlan, final File attachment) {

        final EmailObject email = EmailObject
                .builder()
                .subject(SUBJECT_MESSAGE)
                .messageBody(String.format(MESSAGE_BODY, userMap.get(workoutPlan.getUserId()).getNome(), userMap.get(workoutPlan.getPersonalTrainerId()).getNome()))
                .sendTo(userMap.get(workoutPlan.getUserId()).getLogin())
                .hasAttachment(true)
                .attachment(attachment)
                .build();

        emailSender.sendEmail(email);
    }
}
