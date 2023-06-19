package br.com.pucminas.mefit.user.mapper;

import br.com.pucminas.mefit.user.dto.request.UserRequestDTO;
import br.com.pucminas.mefit.user.dto.response.UserResponseDTO;
import br.com.pucminas.mefit.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserResponseDTO convert(UserEntity entity);

    List<UserResponseDTO> convertList(List<UserEntity> exercises);

    @Mapping(source = "password", target = "passwd")
    UserEntity toEntity(UserRequestDTO request);
}
