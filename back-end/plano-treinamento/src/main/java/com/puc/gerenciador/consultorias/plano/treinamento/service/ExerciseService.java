package com.puc.gerenciador.consultorias.plano.treinamento.service;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.MuscularGroupEnum;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExerciseEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.ExerciseRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ExerciseService {

    private final ExerciseRepository repository;


    public ExerciseService(final ExerciseRepository repository) {
        this.repository = repository;
    }

    public ExerciseEntity saveExercise(final ExerciseRequest request) {

        final ExerciseEntity entity = ExerciseEntity.builder()
                .muscularGroup(MuscularGroupEnum.valueOf(request.getMuscularGroup()))
                .createDate(LocalDateTime.now())
                .name(request.getName())
                .build();

        return repository.save(entity);
    }

    public List<ExerciseEntity> getExercises(@Valid MuscularGroupEnum muscularGroupEnum) {

        return Objects.isNull(muscularGroupEnum) ? repository.findAll() : repository.findByMuscularGroup(muscularGroupEnum);

    }

    @Transactional
    public ExerciseEntity updateExercise(final Long id, final ExerciseRequest request) {

        final ExerciseEntity entity = ExerciseEntity
                .builder()
                .id(id)
                .muscularGroup(MuscularGroupEnum.valueOf(request.getMuscularGroup()))
                .name(request.getName())
                .active(request.getActive())
                .build();

        return repository.save(entity);
    }
}
