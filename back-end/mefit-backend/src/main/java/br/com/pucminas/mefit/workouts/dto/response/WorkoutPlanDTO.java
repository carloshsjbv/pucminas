package br.com.pucminas.mefit.workouts.dto.response;

import br.com.pucminas.mefit.workouts.entity.WorkoutDayEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@ToString
public class WorkoutPlanDTO {

    private Long id;

    private LocalDateTime createDate;

    private Long userId;

    private Long personalTrainerId;

    private Integer reps;

    private Integer series;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Boolean active;

    @Builder.Default
    private boolean sent = false;

    private List<WorkoutDayEntity> workoutDayEntities;

}
