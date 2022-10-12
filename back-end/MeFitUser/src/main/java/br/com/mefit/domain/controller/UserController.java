package br.com.mefit.domain.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mefit.domain.entity.UserEntity;
import br.com.mefit.domain.exception.NotFoundEntityException;
import br.com.mefit.domain.model.request.UserRequest;
import br.com.mefit.domain.services.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	private final UserService userService;
	
	public UserController(final UserService service)
	{
		this.userService = service;
		System.out.println("Controller injected");
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<UserEntity>> listar()
	{
		List<UserEntity> users = userService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	

	@PostMapping
	public ResponseEntity<UserEntity> addUser(@RequestBody final UserRequest user)
	{
		final UserEntity request = UserEntity.builder()
				                   .nome(user.getNome())
				                   .passowrd(user.getPassowrd())
				                   .status(1)
				                   .userType(user.getUserType())
				                   .build();
		
		UserEntity userAdded = userService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(userAdded);
	}
	
	@PutMapping(value = "/{UserId}")
	public ResponseEntity<?> updateUser(@PathVariable("UserId") final Long UserId, @RequestBody final UserRequest user)
	{
		try 
		{
			final UserEntity request = UserEntity.builder()
	                   .nome(user.getNome())
	                   .passowrd(user.getPassowrd())
	                   .status(1)
	                   .userType(user.getUserType())
	                   .build();
			
			UserEntity userUpdated = userService.update(UserId, request);
			return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
		}
		catch (NotFoundEntityException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{UserId}")
	public ResponseEntity<?> remover(@PathVariable("UserId") Long UserId)
	{
		try
		{
		 	userService.remove(UserId);
		 	return ResponseEntity.ok().build();
		}
		catch(NotFoundEntityException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		catch (DataIntegrityViolationException e2) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e2.getMessage());
		}
		catch (Exception e3) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e3.getMessage());
		}
		
	}
	
	@GetMapping(value = "/{login}")
	public ResponseEntity<?> findByLogin(@PathVariable("login") final String login)
	{
		try 
		{
			UserEntity user = userService.findUserByLogin(login);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		catch (NotFoundEntityException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/{status}/{userType}")
	public ResponseEntity<?> findByLogin(@PathVariable("status") final Integer status, @PathVariable("userType") final Long userType)
	{
		try 
		{
			UserEntity user = userService.findUser(status, userType);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		catch (NotFoundEntityException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	

}
