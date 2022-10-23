package com.puc.gerenciador.consultorias.plano.treinamento.cronjob;

import com.puc.gerenciador.consultorias.plano.treinamento.clients.UserServiceClient;
import com.puc.gerenciador.consultorias.plano.treinamento.clients.model.User;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.WorkoutPlanEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.mail.EmailObject;
import com.puc.gerenciador.consultorias.plano.treinamento.mail.EmailSender;
import com.puc.gerenciador.consultorias.plano.treinamento.repository.WorkoutPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    private final WorkoutPlanRepository workoutPlanRepository;

    private final UserServiceClient userServiceClient;

    private final EmailSender emailSender;

    @Value("${total.dias.antes.notificacao.long:5}")
    private long amountOfDaysBeforeNotificationIsSent;

    public DueWorkoutCronJob(
            final WorkoutPlanRepository workoutPlanRepository,
            final UserServiceClient userServiceClient,
            final EmailSender emailSender
    ) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.userServiceClient = userServiceClient;
        this.emailSender = emailSender;
    }

    @Async
    @Scheduled(cron = "* * 7 * * *") // AT 07:00 EVERY DAY
    public void checkForDueWorkoutSessions() {

        log.info("Check for due workout sessions JOB has started at - {} ", LocalDateTime.now());

        final List<User> users = userServiceClient.getUsersByStatusAndUserType(1L, 2L);

        final Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity()));

        if (!userMap.isEmpty()) {

            final List<WorkoutPlanEntity> workoutPlans = workoutPlanRepository.findAllByPersonalTrainerIdInAndActive(
                    userMap.keySet(),
                    true
            );

            log.debug("{} workout plans found. Trying to send email ", workoutPlans.size());

            workoutPlans.forEach(workoutPlan -> {
                if (workoutPlan.getEndDate().isBefore(LocalDateTime.now().minus(amountOfDaysBeforeNotificationIsSent, ChronoUnit.DAYS))) {

                    sendEmail(userMap, workoutPlan);

                    log.info("Email sent to personalId {} regarding due workout id {} from user {}",
                            workoutPlan.getPersonalTrainerId(), workoutPlan.getId(), workoutPlan.getUserId());

                }
            });

        }

        log.info("Check for due workout sessions JOB has ended at - {} ", LocalDateTime.now());

    }

    private void sendEmail(final Map<Long, User> userMap, final WorkoutPlanEntity workoutPlan) {

        final EmailObject email = EmailObject
                .builder()
                .subject(SUBJECT_MESSAGE)
                .messageBody(String.format(MESSAGE_BODY, userMap.get(workoutPlan.getPersonalTrainerId()).getNome(), userMap.get(workoutPlan.getUserId()).getNome()))
                .sendTo(userMap.get(workoutPlan.getPersonalTrainerId()).getLogin())
                .build();

            emailSender.sendEmail(email);

    }
}
