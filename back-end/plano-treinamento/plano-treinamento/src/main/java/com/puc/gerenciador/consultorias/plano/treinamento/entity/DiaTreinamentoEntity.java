package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "DIA_TREINAMENTO", schema = "TREINAMENTOS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class DiaTreinamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCriacao;

    private String diaSemana;

    private Integer exercicio;

    private Long planoTreinoId;

}
