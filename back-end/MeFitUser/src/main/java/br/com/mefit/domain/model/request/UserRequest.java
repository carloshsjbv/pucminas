package br.com.mefit.domain.model.request;

import br.com.mefit.domain.entity.UserTypeEntity;
import lombok.Data;

@Data
public class UserRequest {

	private Long id;
	
	private String login;
	
	private String nome;
	
	private String passowrd;
	
	private Integer status;
	 
	private UserTypeEntity userType;
}
