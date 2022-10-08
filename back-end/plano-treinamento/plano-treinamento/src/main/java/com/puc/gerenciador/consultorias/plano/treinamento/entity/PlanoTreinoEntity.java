package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PLANO_TREINO", schema = "TREINAMENTOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlanoTreinoEntity implements Serializable {
    
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
    
    @OneToMany(mappedBy = "planoTreino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DiaTreinamentoEntity> diasTreinamento;

}
