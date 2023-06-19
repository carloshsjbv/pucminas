package br.com.pucminas.mefit.workouts.service;

import br.com.pucminas.mefit.workouts.dto.request.ExerciseRequest;
import br.com.pucminas.mefit.workouts.entity.ExerciseEntity;
import br.com.pucminas.mefit.workouts.entity.MuscularGroupEnum;
import br.com.pucminas.mefit.workouts.mappers.ExerciseMapper;
import br.com.pucminas.mefit.workouts.repository.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ExerciseService {

    private final ExerciseRepository repository;

    private final ExerciseMapper mapper;


    public ExerciseService(final ExerciseRepository repository) {
        this.repository = repository;
        this.mapper = ExerciseMapper.INSTANCE;
    }

    public ExerciseEntity saveExercise(final ExerciseRequest request) {

        final ExerciseEntity entity = mapper.fromRequestToEntity(request);

        entity.setCreateDate(LocalDateTime.now());

        return repository.save(entity);
    }

    public List<ExerciseEntity> getExercises(@Validated MuscularGroupEnum muscularGroupEnum) {

        return Objects.isNull(muscularGroupEnum) ? repository.findAll() : repository.findByMuscularGroup(muscularGroupEnum);

    }

    @Transactional
    public ExerciseEntity updateExercise(final Long id, final ExerciseRequest request) {

        ExerciseEntity exerciseEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exercise not found"));

        ExerciseEntity updatedEntity = mapper.updateFields(exerciseEntity, request);

        return repository.save(updatedEntity);
    }
}
