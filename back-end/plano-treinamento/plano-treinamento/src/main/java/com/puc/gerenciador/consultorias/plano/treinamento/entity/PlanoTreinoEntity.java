package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PLANO_TREINO", schema = "TREINAMENTOS")
@Getter
@Setter
@EqualsAndHashCode
public class PlanoTreinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCriacao;

    private Long userId;

    private String nomeTreino;

    private Integer repeticoes;

    private Integer series;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private Boolean active = true;

}
