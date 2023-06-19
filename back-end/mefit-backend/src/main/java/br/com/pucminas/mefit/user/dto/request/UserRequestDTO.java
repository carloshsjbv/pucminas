package br.com.pucminas.mefit.user.dto.request;

import br.com.pucminas.mefit.user.entity.EnumStatus;
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
