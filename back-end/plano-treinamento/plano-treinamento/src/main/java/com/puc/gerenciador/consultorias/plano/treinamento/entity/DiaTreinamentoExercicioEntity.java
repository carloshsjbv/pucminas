package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "DIA_TREINAMENTO_EXERCICIO", schema = "TREINAMENTOS")
@IdClass(DiaTreinamentoExercicioEntityPK.class)
public class DiaTreinamentoExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaTreinamentoExercicio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exercicioId;

}
