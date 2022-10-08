package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import lombok.Getter;
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

@Getter
@Setter
@Entity
@Table(name = "PLANO_TREINO")
public class PlanoTreinoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "REPETICOES", nullable = false)
    private Integer repeticoes;

    @Column(name = "SERIES", nullable = false)
    private Integer series;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM", nullable = false)
    private LocalDateTime dataFim;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    @OneToMany(mappedBy = "planoTreinoByPlanoTreinoId")
    private Collection<DiaTreinamentoEntity> diaTreinamentosById;

}
