package br.com.pucminas.workouts.mappers;

import br.com.pucminas.workouts.dto.response.WorkoutPlanDTO;
import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface WorkoutPlanMapper {

    WorkoutPlanMapper INSTANCE = Mappers.getMapper(WorkoutPlanMapper.class);

    WorkoutPlanDTO convert(WorkoutPlanEntity entity);

}
