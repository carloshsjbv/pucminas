package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DIA_TREINAMENTO", schema = "TREINAMENTOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DiaTreinamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "DIA_SEMANA", nullable = false)
    private String diaSemana;

    @ManyToOne
    @JoinColumn(name = "PLANO_TREINO_ID", referencedColumnName = "ID")
    private PlanoTreinoEntity planoTreino;

    @ManyToMany
    @JoinTable(
            name = "DIA_TREINAMENTO_X_EXERCICIO",
            joinColumns = @JoinColumn(name = "dia_treinamento_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    private Set<ExercicioEntity> exercicios;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public Set<ExercicioEntity> getExercicios() {
        return exercicios;
    }

}
