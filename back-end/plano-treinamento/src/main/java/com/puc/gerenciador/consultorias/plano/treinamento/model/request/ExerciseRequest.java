package com.puc.gerenciador.consultorias.plano.treinamento.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseRequest {

    private String name;

    private String muscularGroup;

    private Boolean active;

}
