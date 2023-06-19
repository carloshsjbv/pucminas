package br.com.pucminas.user.dto.response;

import br.com.pucminas.user.entity.EnumStatus;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserResponseDTO {

    private String login;

    private String nome;

    private EnumStatus status;

    private UserTypeResponseDTO userType;
}
