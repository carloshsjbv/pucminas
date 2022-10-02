package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class DiaTreinamentoExercicioEntityPK implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaTreinamentoExercicio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId;

}
