package br.com.pucminas.mefit.workouts.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class WorkoutDayRequest {

    @NotBlank
    private String weekDay;

    @NotEmpty
    private List<Long> exerciseIds;

}
