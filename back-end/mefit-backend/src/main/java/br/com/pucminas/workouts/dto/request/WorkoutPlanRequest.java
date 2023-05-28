package br.com.pucminas.workouts.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private List<WorkoutDayRequest> workoutDays;

}
