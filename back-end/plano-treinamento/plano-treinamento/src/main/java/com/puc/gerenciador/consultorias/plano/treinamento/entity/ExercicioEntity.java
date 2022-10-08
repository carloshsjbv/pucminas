package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXERCICIO", schema = "TREINAMENTOS")
public class ExercicioEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "NOME_EXERCICIO", nullable = false)
    private String nomeExercicio;

    @Enumerated(EnumType.STRING)
    private EnumGrupoMuscular grupoMuscular;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public EnumGrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public Boolean getActive() {
        return active;
    }
}
