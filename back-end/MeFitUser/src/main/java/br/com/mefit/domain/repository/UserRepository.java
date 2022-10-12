package br.com.mefit.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mefit.domain.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("select u from UserEntity u where u.status = ?1 and user_type_id = ?2")
	Optional<UserEntity> findUser(Integer status, Long userType);
	
	
	//@Query("select * from user u where u.status = ?1")
	@Query("select u from UserEntity u where u.login = ?1")
	Optional<UserEntity> findUserByLogin(String login);
	
}
