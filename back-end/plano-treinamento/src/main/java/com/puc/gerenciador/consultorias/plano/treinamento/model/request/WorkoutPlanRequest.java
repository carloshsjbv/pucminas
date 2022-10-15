package com.puc.gerenciador.consultorias.plano.treinamento.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class WorkoutPlanRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long personalTrainerId;

    @NotNull
    private Integer reps;

    @NotNull
    private Integer series;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @NotNull
    @NotEmpty
    private List<WorkoutDayRequest> workoutDays;

}
