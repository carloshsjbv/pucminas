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
@Table(name = "EXERCISE", schema = "WORKOUTS")
public class ExerciseEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MuscularGroupEnum muscularGroup;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    public Long getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getName() {
        return name;
    }

    public MuscularGroupEnum getMuscularGroup() {
        return muscularGroup;
    }

    public Boolean getActive() {
        return active;
    }
}
