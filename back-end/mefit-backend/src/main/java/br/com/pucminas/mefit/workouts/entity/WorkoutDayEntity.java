package br.com.pucminas.workouts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT_DAY", schema = "MEFIT")
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
