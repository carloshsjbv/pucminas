package com.puc.gerenciador.consultorias.plano.treinamento.service;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.EnumGrupoMuscular;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExercicioEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.ExercicioRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository repository;


    public ExercicioService(final ExercicioRepository repository) {
        this.repository = repository;
    }

    public ExercicioEntity criarExercicio(final ExercicioRequest request) {

        final ExercicioEntity entity = ExercicioEntity.builder()
                .grupoMuscular(EnumGrupoMuscular.valueOf(request.getGrupoMuscular()))
                .dataCriacao(LocalDateTime.now())
                .nomeExercicio(request.getNomeExercicio())
                .build();

        return repository.save(entity);
    }

    public List<ExercicioEntity> listarExercicios() {
        return repository.findAll();
    }

    @Transactional
    public ExercicioEntity atualizarExercicio(final Long id, final ExercicioRequest request) {

        final ExercicioEntity entity = ExercicioEntity
                .builder()
                .id(id)
                .grupoMuscular(EnumGrupoMuscular.valueOf(request.getGrupoMuscular()))
                .nomeExercicio(request.getNomeExercicio())
                .active(request.getActive())
                .build();

        return repository.save(entity);
    }
}
