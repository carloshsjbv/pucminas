package com.puc.gerenciador.consultorias.plano.treinamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT_DAY", schema = "WORKOUTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkoutDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "WEEK_DAY", nullable = false)
    private String weekDay;

    @ManyToOne
    @JoinColumn(name = "WORKOUT_PLAN_ID", referencedColumnName = "ID")
    private WorkoutPlanEntity workoutPlan;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "WORKOUT_DAY_X_EXERCISE",
            joinColumns = @JoinColumn(name = "WORKOUT_DAY_ID"),
            inverseJoinColumns = @JoinColumn(name = "EXERCISE_ID"))
    private Set<ExerciseEntity> exercises;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public Set<ExerciseEntity> getExercises() {
        return exercises;
    }

}
