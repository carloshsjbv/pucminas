package com.puc.gerenciador.consultorias.plano.treinamento.controllers;

import com.puc.gerenciador.consultorias.plano.treinamento.entity.WorkoutPlanEntity;
import com.puc.gerenciador.consultorias.plano.treinamento.model.request.WorkoutPlanRequest;
import com.puc.gerenciador.consultorias.plano.treinamento.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/plano-treino")
public class WorkoutPlan {

    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlan(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }


    @PostMapping
    public WorkoutPlanEntity saveWorkoutPlan(@RequestBody @Valid final WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanService.saveWorkoutPlan(workoutPlanRequest);
    }

    @GetMapping("/{id}")
    public WorkoutPlanEntity getWorkoutPlanById(@PathVariable("id") @Valid final Long id) {
        return workoutPlanService.getWorkoutPlanById(id);
    }


}
