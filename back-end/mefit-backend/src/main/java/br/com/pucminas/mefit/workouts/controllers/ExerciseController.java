package br.com.pucminas.workouts.controllers;

import br.com.pucminas.workouts.dto.request.ExerciseRequest;
import br.com.pucminas.workouts.dto.response.ExerciseResponseDTO;
import br.com.pucminas.workouts.entity.MuscularGroupEnum;
import br.com.pucminas.workouts.mappers.ExerciseMapper;
import br.com.pucminas.workouts.service.ExerciseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/exercises")
public class ExerciseController {

    private final ExerciseService service;

    private final ExerciseMapper exerciseMapper;


    public ExerciseController(
            final ExerciseService service
    ) {
        this.service = service;
        this.exerciseMapper = ExerciseMapper.INSTANCE;
    }

    @PostMapping
    public ExerciseResponseDTO createExercise(@RequestBody final ExerciseRequest request) {
        return exerciseMapper.fromEntityToDTO(service.saveExercise(request));
    }

    @GetMapping
    public List<ExerciseResponseDTO> getExercises(
            @RequestParam(required = false) @Validated MuscularGroupEnum muscularGroupEnum
    ) {
        return exerciseMapper.fromEntityListToDTOList(service.getExercises(muscularGroupEnum));
    }

    @PutMapping("/{id}")
    public ExerciseResponseDTO updateExercises(@PathVariable final Long id, @RequestBody final ExerciseRequest requestBody) {
        return exerciseMapper.fromEntityToDTO(service.updateExercise(id, requestBody));
    }

}
