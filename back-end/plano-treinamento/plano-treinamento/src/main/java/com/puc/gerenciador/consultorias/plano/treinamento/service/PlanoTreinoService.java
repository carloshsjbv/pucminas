package com.puc.gerenciador.consultorias.plano.treinamento.service;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.DiaTreinamentoEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExercicioEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.PlanoTreinoEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.DiaTreinamentoRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.PlanoTreinoRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.repository.PlanoTreinoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoTreinoService {

    private final PlanoTreinoRepository repository;

    public PlanoTreinoService(PlanoTreinoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PlanoTreinoEntity inserirPlanoTreino(final PlanoTreinoRequest planoTreinoRequest) {

        validarIntervaloDeDatas(planoTreinoRequest);

        final List<DiaTreinamentoEntity> diasTreinamento = planoTreinoRequest
                .getDiaTreinamentoRequests()
                .stream()
                .map(PlanoTreinoService::toDiaTreinamentoEntity)
                .collect(Collectors.toList());

        final PlanoTreinoEntity planoTreinoEntity = PlanoTreinoEntity.builder()
                .userId(planoTreinoRequest.getUserId())
                .dataCriacao(LocalDateTime.now())
                .repeticoes(planoTreinoRequest.getRepeticoes())
                .series(planoTreinoRequest.getSeries())
                .dataInicio(planoTreinoRequest.getDataInicio())
                .dataFim(planoTreinoRequest.getDataFim())
                .active(true)
                .build();

        diasTreinamento.forEach(dia -> dia.setPlanoTreino(planoTreinoEntity));

        planoTreinoEntity.setDiasTreinamento(diasTreinamento);

        return repository.save(planoTreinoEntity);
    }

    public PlanoTreinoEntity getPlanoTreino(final Long id) {
        return repository.getReferenceById(id);
    }

    private void validarIntervaloDeDatas(PlanoTreinoRequest planoTreinoRequest) {

        if (planoTreinoRequest.getDataFim().isBefore(planoTreinoRequest.getDataInicio()) ||
                planoTreinoRequest.getDataInicio().isAfter(planoTreinoRequest.getDataFim())) {
            throw new RuntimeException("Intervalo de datas invalido");
        }
    }

    private static DiaTreinamentoEntity toDiaTreinamentoEntity(DiaTreinamentoRequest request) {
        return DiaTreinamentoEntity
                .builder()
                .dataCriacao(LocalDateTime.now())
                .diaSemana(request.getDiaSemana())
                .exercicios(
                        request.getExercicioIds()
                                .stream()
                                .map(PlanoTreinoService::getExercicio)
                                .collect(Collectors.toSet()))
                .build();
    }

    private static ExercicioEntity getExercicio(Long exercicioId) {
        return ExercicioEntity.builder().id(exercicioId).build();
    }


}
