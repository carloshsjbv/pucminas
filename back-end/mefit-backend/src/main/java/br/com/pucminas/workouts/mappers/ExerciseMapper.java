package br.com.pucminas.workouts.mappers;

import br.com.pucminas.workouts.dto.request.ExerciseRequest;
import br.com.pucminas.workouts.dto.response.ExerciseResponseDTO;
import br.com.pucminas.workouts.entity.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExerciseMapper {


    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);


    ExerciseResponseDTO fromEntityToDTO(ExerciseEntity entity);

    List<ExerciseResponseDTO> fromEntityListToDTOList(List<ExerciseEntity> exercises);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "active", source = "active", defaultValue = "true")
    ExerciseEntity fromRequestToEntity(ExerciseRequest request);

    default ExerciseEntity updateFields(ExerciseEntity exerciseEntity, ExerciseRequest request){
        exerciseEntity.setName(request.getName());
        exerciseEntity.setMuscularGroup(request.getMuscularGroup());
        exerciseEntity.setActive(request.getActive());

        return exerciseEntity;
    }
}
