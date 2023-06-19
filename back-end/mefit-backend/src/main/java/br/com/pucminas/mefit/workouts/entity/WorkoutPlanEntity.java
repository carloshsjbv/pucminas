package br.com.pucminas.mefit.workouts.entity;

import br.com.pucminas.mefit.user.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKOUT_PLAN", schema = "MEFIT")
public class WorkoutPlanEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "PERSONAL_ID", nullable = false)
    private UserEntity personalTrainerId;

    @Column(name = "REPS", nullable = false)
    private Integer reps;

    @Column(name = "SERIES", nullable = false)
    private Integer series;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name = "ACTIVE")
    private Boolean active;
    
    @Column(name = "SENT")
    @Builder.Default
    private Boolean sent = false;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkoutDayEntity> workoutDayEntities;

}
