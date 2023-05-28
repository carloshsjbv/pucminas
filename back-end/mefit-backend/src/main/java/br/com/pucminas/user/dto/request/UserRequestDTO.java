package br.com.pucminas.user.dto.request;

import br.com.pucminas.user.entity.EnumStatus;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private Long id;

    private String login;

    private String nome;

    private String password;

    @Null(message = "este campo não deve ser preenchido")
    private EnumStatus status;

    private UserTypeRequestDTO userType;
}
