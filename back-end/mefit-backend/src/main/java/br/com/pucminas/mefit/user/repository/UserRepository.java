package br.com.pucminas.user.repository;

import br.com.pucminas.user.entity.EnumStatus;
import br.com.pucminas.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByLogin(String login);

    List<UserEntity> findUsersByStatusAndUserTypeId(EnumStatus status, Long userTypeId);

}