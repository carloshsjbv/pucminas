package com.puc.gerenciador.consultorias.plano.treinamento.service;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.WorkoutDayEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExerciseEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.WorkoutPlanEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.WorkoutDayRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.WorkoutPlanRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanRepository repository;

    public WorkoutPlanService(WorkoutPlanRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public WorkoutPlanEntity saveWorkoutPlan(final WorkoutPlanRequest workoutPlanRequest) {

        validateDateRange(workoutPlanRequest.getStartDate(), workoutPlanRequest.getEndDate());

        final List<WorkoutDayEntity> workoutDayEntities = workoutPlanRequest
                .getWorkoutDays()
                .stream()
                .map(WorkoutPlanService::toWorkoutDayEntity)
                .collect(Collectors.toList());

        final WorkoutPlanEntity workoutPlanEntity = WorkoutPlanEntity.builder()
                .userId(workoutPlanRequest.getUserId())
                .personalTrainerId(workoutPlanRequest.getPersonalTrainerId())
                .createDate(LocalDateTime.now())
                .reps(workoutPlanRequest.getReps())
                .series(workoutPlanRequest.getSeries())
                .startDate(workoutPlanRequest.getStartDate())
                .endDate(workoutPlanRequest.getEndDate())
                .active(true)
                .build();

        workoutDayEntities.forEach(dia -> dia.setWorkoutPlan(workoutPlanEntity));

        workoutPlanEntity.setWorkoutDayEntities(workoutDayEntities);

        return repository.save(workoutPlanEntity);
    }

    public WorkoutPlanEntity getWorkoutPlanById(final Long id) {
        final WorkoutPlanEntity workoutPlan = repository.getReferenceById(id);

        if(Objects.isNull(workoutPlan)) {
            throw new EntityNotFoundException("Workout plan not found");
        }

        return repository.getReferenceById(id);
    }

    private void validateDateRange(final LocalDateTime startDate, final LocalDateTime endDate) {

        if (endDate.isBefore(startDate) || startDate.isAfter(endDate)) {
            throw new RuntimeException("Invalid date range");
        }
    }

    private static WorkoutDayEntity toWorkoutDayEntity(final WorkoutDayRequest request) {
        return WorkoutDayEntity
                .builder()
                .createDate(LocalDateTime.now())
                .weekDay(request.getWeekDay())
                .exercises(
                        request.getExerciseIds()
                                .stream()
                                .map(WorkoutPlanService::getExercise)
                                .collect(Collectors.toSet()))
                .build();
    }

    private static ExerciseEntity getExercise(final Long exerciseId) {
        return ExerciseEntity.builder().id(exerciseId).build();
    }


    @Transactional
    public List<WorkoutPlanEntity> findAllBySent(boolean active) {
        return repository.findAllBySent(active);
    }

    @Transactional
    public void updateWorkoutPlan(final WorkoutPlanEntity workoutPlanEntity) {
        repository.save(workoutPlanEntity);
    }
}
