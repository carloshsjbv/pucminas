package br.com.pucminas.workouts.controllers;

import br.com.pucminas.workouts.dto.request.WorkoutPlanRequest;
import br.com.pucminas.workouts.dto.response.WorkoutPlanDTO;
import br.com.pucminas.workouts.mappers.WorkoutPlanMapper;
import br.com.pucminas.workouts.service.WorkoutPlanService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/workout-plans")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;
    private final WorkoutPlanMapper workoutPlanMapper;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
        this.workoutPlanMapper = WorkoutPlanMapper.INSTANCE;
    }


    @PostMapping
    public WorkoutPlanDTO saveWorkoutPlan(@RequestBody @Validated final WorkoutPlanRequest workoutPlanRequest) {
        return workoutPlanMapper.convert(workoutPlanService.saveWorkoutPlan(workoutPlanRequest));
    }

    @GetMapping("/{id}")
    public WorkoutPlanDTO getWorkoutPlanById(@PathVariable("id") @Validated final Long id) {
        return workoutPlanMapper.convert(workoutPlanService.getWorkoutPlanById(id));
    }


}
