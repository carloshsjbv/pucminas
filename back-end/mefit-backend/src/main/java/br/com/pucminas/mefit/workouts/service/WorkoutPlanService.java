package br.com.pucminas.workouts.service;

import br.com.pucminas.user.entity.UserEntity;
import br.com.pucminas.workouts.dto.request.WorkoutDayRequest;
import br.com.pucminas.workouts.dto.request.WorkoutPlanRequest;
import br.com.pucminas.workouts.entity.ExerciseEntity;
import br.com.pucminas.workouts.entity.WorkoutDayEntity;
import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import br.com.pucminas.workouts.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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
                .userId(UserEntity.builder().id(workoutPlanRequest.getUserId()).build())
                .personalTrainerId(UserEntity.builder().id(workoutPlanRequest.getPersonalTrainerId()).build())
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
        return repository.getReferenceById(id);
    }

    private void validateDateRange(final LocalDate startDate, final LocalDate endDate) {

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


    public List<WorkoutPlanEntity> findAllBySent(boolean active) {
        return repository.findAllBySent(active);
    }

    @Transactional
    public void updateWorkoutPlan(final WorkoutPlanEntity workoutPlanEntity) {
        repository.save(workoutPlanEntity);
    }

    public List<WorkoutPlanEntity> findAllByPersonalTrainerIdInAndActive(final Set<Long> personalTrainerId, final boolean active) {
        return repository.findAllByPersonalTrainerIdInAndActive(personalTrainerId, active);
    }

}
