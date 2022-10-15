package br.com.mefit.domain.repository;

import br.com.mefit.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	//@Query("select * from user u where u.status = ?1")
	@Query("select u from UserEntity u where u.login = ?1")
	Optional<UserEntity> findUserByLogin(String login);

	List<UserEntity> findUsersByStatusAndUserTypeId(Integer status, Long userTypeId);

}
