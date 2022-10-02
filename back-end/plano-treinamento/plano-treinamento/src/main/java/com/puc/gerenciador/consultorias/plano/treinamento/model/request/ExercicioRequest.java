package com.puc.gerenciador.consultorias.plano.treinamento.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExercicioRequest {

    private String nomeExercicio;

    private String grupoMuscular;

    private Boolean active;

}
