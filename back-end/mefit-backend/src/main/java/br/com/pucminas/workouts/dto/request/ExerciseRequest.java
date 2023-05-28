package br.com.pucminas.workouts.dto.request;

import br.com.pucminas.workouts.entity.MuscularGroupEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ExerciseRequest {

    @NotBlank
    private String name;

    @NotBlank
    private MuscularGroupEnum muscularGroup;

    private Boolean active;

}
