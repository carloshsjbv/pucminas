package com.puc.gerenciador.consultorias.plano.treinamento.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class DiaTreinamentoRequest {

    @NotBlank
    private String diaSemana;

    @NotNull
    @NotEmpty
    private List<Long> exercicioIds;

}
