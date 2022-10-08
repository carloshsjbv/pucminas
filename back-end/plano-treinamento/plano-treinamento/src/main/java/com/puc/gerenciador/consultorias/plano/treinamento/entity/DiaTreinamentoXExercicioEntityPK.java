package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public class DiaTreinamentoXExercicioEntityPK implements Serializable {

    @Id
    @Column(name = "EXERCICIO_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId;

    @Column(name = "DIA_TREINAMENTO_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaTreinamentoId;

}
