package com.puc.gerenciador.consultorias.plano.treinamento.controllers;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.MuscularGroupEnum;
import com.puc.gerenciador.consultorias.plano.treinamento.entity.ExerciseEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.ExerciseRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(final ExerciseService service) {
        this.service = service;
    }

    @PostMapping
    public ExerciseEntity criarExercicio(@RequestBody final ExerciseRequest request) {
        return service.saveExercise(request);
    }

    @GetMapping
    public List<ExerciseEntity> getExercicios(
            @RequestParam(required = false) @Valid MuscularGroupEnum muscularGroupEnum
    ) {
        return service.getExercises(muscularGroupEnum);
    }

    @PatchMapping
    public ExerciseEntity getExercicios(@RequestParam final Long id, @RequestBody final ExerciseRequest requestBody) {
        return service.updateExercise(id, requestBody);
    }

}
