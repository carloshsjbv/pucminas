package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "EXERCICIO", schema = "TREINAMENTOS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ExercicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCriacao;

    private String nomeExercicio;

    @Enumerated(EnumType.STRING)
    private EnumGrupoMuscular grupoMuscular;

    @Builder.Default
    private Boolean active = true;

}
