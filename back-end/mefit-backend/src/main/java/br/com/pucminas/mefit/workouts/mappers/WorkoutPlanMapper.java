package br.com.pucminas.workouts.mappers;

import br.com.pucminas.workouts.dto.response.WorkoutPlanDTO;
import br.com.pucminas.workouts.entity.WorkoutPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface WorkoutPlanMapper {

    WorkoutPlanMapper INSTANCE = Mappers.getMapper(WorkoutPlanMapper.class);

    @Mapping(source = "userId.id", target = "userId")
    @Mapping(source = "personalTrainerId.id", target = "personalTrainerId")
    WorkoutPlanDTO convert(WorkoutPlanEntity entity);

}
