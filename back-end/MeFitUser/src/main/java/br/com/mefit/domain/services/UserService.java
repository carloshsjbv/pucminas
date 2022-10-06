package br.com.mefit.domain.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.mefit.domain.exception.NotFoundEntityException;
import br.com.mefit.domain.model.User;
import br.com.mefit.domain.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService()
	{
		System.out.println("User Service loaded");
	}
	
	public User save(User user)
	{
		return userRepository.save(user);
	}
	
	public User update(Long userId, User user)
	{
		Optional<User> userBeforeUpdate = userRepository.findById(userId);
		
		if (userBeforeUpdate.isPresent())
		{
			BeanUtils.copyProperties(user, userBeforeUpdate, "id");
			User cidadeSaved = userRepository.save(user);
			return cidadeSaved;
		}
		throw new NotFoundEntityException(String.format("User %d not found", userId));
	}
	
	public void remove(Long userId) throws Exception
	{
		try 
		{
			userRepository.deleteById(userId);
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
}
