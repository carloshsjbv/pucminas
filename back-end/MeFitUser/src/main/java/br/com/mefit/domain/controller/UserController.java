package br.com.mefit.domain.controller;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mefit.domain.exception.NotFoundEntityException;
import br.com.mefit.domain.model.User;
import br.com.mefit.domain.services.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
//	@Autowired(required = true)
//	private IUserRepository userRepository;
	
	public UserController()
	{
		System.out.println("Controller injected");
	}
	
	@Autowired(required = true)
	private UserService userService;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> listar()
	{
		return ResponseEntity.ok("ok");
	}
	
	@PostMapping
	public ResponseEntity<User> adicionar(@RequestBody User User)
	{
		User = userService.save(User);
		return ResponseEntity.status(HttpStatus.CREATED).body(User);
	}
	
	@PutMapping(value = "/{UserId}")
	public ResponseEntity<?> atualizar(@PathParam("UserId") Long UserId, @RequestBody User User)
	{
		try 
		{
			User = userService.update(UserId, User);
			return ResponseEntity.status(HttpStatus.OK).body(User);
		}
		catch (NotFoundEntityException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{UserId}")
	public ResponseEntity<?> remover(@PathParam("UserId") Long UserId)
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
	
	

}
