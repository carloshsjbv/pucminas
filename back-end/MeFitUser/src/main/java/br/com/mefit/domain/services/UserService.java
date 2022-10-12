package br.com.mefit.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mefit.domain.entity.UserEntity;
import br.com.mefit.domain.exception.NotFoundEntityException;
import br.com.mefit.domain.repository.UserRepository;

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
	
	
	public UserEntity findUser(Integer status, Long userType)
	{
		Optional<UserEntity> user = repository.findUser(status, userType);
		
		if (user.isPresent())
			return user.get();
		
		throw new NotFoundEntityException(String.format("User %d not found", userType));
	}
	
	public UserEntity findUserByLogin(String login)
	{
		Optional<UserEntity> user = repository.findUserByLogin(login);
		if (user.isPresent())
			return user.get();
		
		throw new NotFoundEntityException(String.format("User %d not found", login));
		
	}
	
	
	
}
