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
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT_PLAN", schema = "WORKOUTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkoutPlanEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "PERSONAL_ID", nullable = false)
    private Long personalTrainerId;

    @Column(name = "REPS", nullable = false)
    private Integer reps;

    @Column(name = "SERIES", nullable = false)
    private Integer series;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    @Column(name = "SENT")
    @Builder.Default
    private Boolean sent = false;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkoutDayEntity> workoutDayEntities;

    public String getFormmatedLocalDateFromDateTime(final LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}
