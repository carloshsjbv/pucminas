package br.com.pucminas.reports;

import br.com.pucminas.user.entity.EnumStatus;
import br.com.pucminas.user.entity.UserEntity;
import br.com.pucminas.user.service.UserService;
import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import br.com.pucminas.workouts.service.WorkoutPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DueWorkoutCronJob {

    public static final String SUBJECT_MESSAGE = "Lembrete de término de plano de treino";

    public static final String MESSAGE_BODY = "Olá %s!<br/><br/>" +
            "O prazo de renovação do plano de treino do seu aluno %s está chegando!<br/><br/>" +
            "Fique atento e se lembre de acessar o Me-fit app para o cadastro de um novo ainda esta semana.<br/><br/>" +
            "Obrigado!<br/>" +
            "Time Me-fit App";
    public static final int ACTIVE_USER_STATUS_ID = 1;
    public static final long TRAINEE_USER_TYPE_ID = 2L;

    private final WorkoutPlanService workoutPlanService;

    private final UserService userService;

    private final EmailSender emailSender;

    @Value("${total.dias.antes.notificacao.long:5}")
    private long amountOfDaysBeforeNotificationIsSent;

    public DueWorkoutCronJob(
            final WorkoutPlanService workoutPlanService,
            final UserService userService,
            final EmailSender emailSender
    ) {
        this.workoutPlanService = workoutPlanService;
        this.userService = userService;
        this.emailSender = emailSender;
    }

    @Async
    @Scheduled(cron = "* * 7 * * *") // AT 07:00 EVERY DAY
    //@Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkForDueWorkoutSessions() {

        log.info("Check for due workout sessions JOB has started at - {} ", LocalDateTime.now());

        final List<UserEntity> users = userService.findUsersByStatusAndUserTypeId(EnumStatus.ACTIVE, TRAINEE_USER_TYPE_ID);

        final Map<Long, UserEntity> userMap = users.stream().collect(Collectors.toMap(UserEntity::getId, Function.identity()));

        if (!userMap.isEmpty()) {

            final List<WorkoutPlanEntity> workoutPlans = workoutPlanService.findAllByPersonalTrainerIdInAndActive(
                    userMap.keySet(),
                    true
            );

            if (workoutPlans.isEmpty()) {
                log.info("No due workouts found. Check for due workout sessions job has early ended at - {} ", LocalDateTime.now());

                return;
            }

            log.debug("{} workout plans found. Trying to send email ", workoutPlans.size());

            workoutPlans.forEach(workoutPlan -> {
                if (workoutPlan.getEndDate().isBefore(LocalDate.now().minus(amountOfDaysBeforeNotificationIsSent, ChronoUnit.DAYS))) {

                    sendEmail(userMap, workoutPlan);

                    log.info("Email sent to personalId [{}], due workout id [{}] userId [{}]",
                            workoutPlan.getPersonalTrainerId(), workoutPlan.getId(), workoutPlan.getUserId());

                }
            });

        }

        log.info("Check for due workout sessions JOB has ended at - {} ", LocalDateTime.now());

    }

    private void sendEmail(final Map<Long, UserEntity> userMap, final WorkoutPlanEntity workoutPlan) {

        final EmailObject email = EmailObject
                .builder()
                .subject(SUBJECT_MESSAGE)
                .messageBody(String.format(MESSAGE_BODY, userMap.get(workoutPlan.getPersonalTrainerId()).getNome(), userMap.get(workoutPlan.getUserId()).getNome()))
                .sendTo(userMap.get(workoutPlan.getPersonalTrainerId()).getLogin())
                .build();

            emailSender.sendEmail(email);

    }
}
