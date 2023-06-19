package br.com.pucminas.workouts.dto.response;

import br.com.pucminas.workouts.entity.MuscularGroupEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
public class ExerciseResponseDTO {

    private Long id;
    private LocalDateTime createDate;
    private String name;
    private MuscularGroupEnum muscularGroup;
    private Boolean active;

}
