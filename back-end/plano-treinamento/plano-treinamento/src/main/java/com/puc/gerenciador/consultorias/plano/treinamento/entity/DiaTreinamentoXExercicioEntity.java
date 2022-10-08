package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "DIA_TREINAMENTO_X_EXERCICIO")
@IdClass(DiaTreinamentoXExercicioEntityPK.class)
public class DiaTreinamentoXExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXERCICIO_ID", nullable = false)
    private Long exercicioId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIA_TREINAMENTO_ID", nullable = false)
    private Integer diaTreinamentoId;

    @ManyToOne
    @JoinColumn(name = "EXERCICIO_ID", referencedColumnName = "ID", nullable = false)
    private ExercicioEntity exercicioByExercicioId;

    @ManyToOne
    @JoinColumn(name = "DIA_TREINAMENTO_ID", referencedColumnName = "ID", nullable = false)
    private DiaTreinamentoEntity diaTreinamentoByDiaTreinamentoId;

}
