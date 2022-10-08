package com.puc.gerenciador.consultorias.plano.treinamento.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PlanoTreinoRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Integer repeticoes;

    @NotNull
    private Integer series;

    @NotNull
    private LocalDateTime dataInicio;

    @NotNull
    private LocalDateTime dataFim;

    @NotNull
    @NotEmpty
    private List<DiaTreinamentoRequest> diaTreinamentoRequests;

}
