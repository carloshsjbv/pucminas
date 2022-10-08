package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "DIA_TREINAMENTO")
public class DiaTreinamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DIA_SEMANA", nullable = false, length = 255)
    private String diaSemana;

    @Column(name = "PLANO_TREINO_ID")
    private Integer planoTreinoId;

    @ManyToOne
    @JoinColumn(name = "PLANO_TREINO_ID", referencedColumnName = "ID")
    private PlanoTreinoEntity planoTreinoByPlanoTreinoId;

    @OneToMany(mappedBy = "diaTreinamentoByDiaTreinamentoId")
    private Collection<DiaTreinamentoXExercicioEntity> diaTreinamentoXExerciciosById;

}
