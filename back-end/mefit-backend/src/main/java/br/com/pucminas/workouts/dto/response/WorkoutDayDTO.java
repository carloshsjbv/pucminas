package br.com.pucminas.workouts.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
public class WorkoutDayDTO {

    private Long id;
    private LocalDateTime createDate;
    private String weekDay;
    private WorkoutPlanDTO workoutPlan;

}
