package br.com.mefit.domain.services;

import br.com.mefit.domain.entity.UserEntity;
import br.com.mefit.domain.exception.NotFoundEntityException;
import br.com.mefit.domain.model.response.UserResponseObject;
import br.com.mefit.domain.model.response.UserTypeResponseObject;
import br.com.mefit.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService(final UserRepository repository)
	{
		System.out.println("user loaded");
		this.repository = repository;
	}
	
	@Transactional
	public UserEntity save(UserEntity user)
	{
		return repository.save(user);
	}
	
	@Transactional
	public UserEntity update(Long userId, UserEntity user)
	{
		Optional<UserEntity> userBeforeUpdate = repository.findById(userId);
		
		if (userBeforeUpdate.isPresent())
		{
			BeanUtils.copyProperties(user, userBeforeUpdate, "id");
			UserEntity cidadeSaved = repository.save(user);
			return cidadeSaved;
		}
		throw new NotFoundEntityException(String.format("User %d not found", userId));
	}
	
	@Transactional
	public void remove(Long userId) throws Exception
	{
		try 
		{
			repository.deleteById(userId);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new NotFoundEntityException(String.format("User %d not found", userId));
		}
		catch (DataIntegrityViolationException e2) {
			throw new DataIntegrityViolationException(String.format("User %d cannot be remove", userId));
		}
		catch (Exception e3) {
			throw new Exception(e3.getMessage());
		}
	}
	
	public List<UserEntity> findAll()
	{
		return repository.findAll();
	}
	
	
	public List<UserResponseObject> findUsersByStatusAndUserTypeId(Integer status, Long userTypeId)
	{
		final List<UserEntity> usersByStatusAndUserTypeId = repository.findUsersByStatusAndUserTypeId(status, userTypeId);

		return usersByStatusAndUserTypeId.stream().map(user -> toResponseObject(user)).collect(Collectors.toList());
	}

	public UserEntity findUserByLogin(String login)
	{
		Optional<UserEntity> user = repository.findUserByLogin(login);
		if (user.isPresent())
			return user.get();
		
		throw new NotFoundEntityException(String.format("User %d not found", login));
		
	}

	private UserResponseObject toResponseObject(UserEntity userEntity) {

		return UserResponseObject
				.builder()
				.id(userEntity.getId())
				.nome(userEntity.getNome())
				.status(userEntity.getStatus())
				.login(userEntity.getLogin())
				.userTypeResponseObject(UserTypeResponseObject
						.builder()
						.id(userEntity.getUserType().getId())
						.nome(userEntity.getUserType().getNome())
						.build()
				)
				.build();
	}

}
