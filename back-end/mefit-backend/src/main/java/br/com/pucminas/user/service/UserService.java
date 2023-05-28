package br.com.pucminas.user.service;

import br.com.pucminas.user.dto.request.UserRequestDTO;
import br.com.pucminas.user.entity.EnumStatus;
import br.com.pucminas.user.entity.UserEntity;
import br.com.pucminas.user.mapper.UserMapper;
import br.com.pucminas.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;


    public UserService(UserRepository repository) {
        this.repository = repository;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Transactional
    public UserEntity save(final UserRequestDTO request) {

        UserEntity userEntity = this.userMapper.toEntity(request);

        userEntity.setStatus(EnumStatus.ACTIVE);

        return repository.save(userEntity);
    }

    @Transactional
    public UserEntity update(Long userId, UserRequestDTO request) {
        UserEntity userEntity = this.userMapper.toEntity(request);

        Optional<UserEntity> userBeforeUpdate = repository.findById(userId);

        if (userBeforeUpdate.isPresent()) {
            BeanUtils.copyProperties(userEntity, userBeforeUpdate, "id");
            return repository.save(userEntity);
        }

        throw new EntityNotFoundException(String.format("User %d not found", userId));
    }


    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public void remove(Long userId) {
        repository.deleteById(userId);
    }

    public UserEntity findUserByLogin(String login) {
        return repository.findUserByLogin(login).orElseThrow(() -> new EntityNotFoundException(String.format("User %s not found", login)));
    }

    public List<UserEntity> findUsersByStatusAndUserTypeId(EnumStatus status, Long userTypeId) {
        return repository.findUsersByStatusAndUserTypeId(status, userTypeId);
    }
}
