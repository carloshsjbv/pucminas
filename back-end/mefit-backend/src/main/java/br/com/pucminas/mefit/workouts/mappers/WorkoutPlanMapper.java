package br.com.pucminas.mefit.workouts.mappers;

import br.com.pucminas.mefit.workouts.entity.WorkoutPlanEntity;
import br.com.pucminas.mefit.workouts.dto.response.WorkoutPlanDTO;
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
