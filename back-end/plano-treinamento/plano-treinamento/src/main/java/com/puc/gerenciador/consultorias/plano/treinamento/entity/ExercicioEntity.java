package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXERCICIO")
public class ExercicioEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "NOME_EXERCICIO", nullable = false, length = 255)
    private String nomeExercicio;

    @Column(name = "GRUPO_MUSCULAR", nullable = false)
    private EnumGrupoMuscular grupoMuscular;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    @OneToMany(mappedBy = "exercicioByExercicioId")
    private Collection<DiaTreinamentoXExercicioEntity> diaTreinamentoXExerciciosById;

}
