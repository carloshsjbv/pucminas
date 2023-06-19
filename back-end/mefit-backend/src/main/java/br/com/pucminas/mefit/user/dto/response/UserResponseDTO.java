package br.com.pucminas.mefit.user.dto.response;

import br.com.pucminas.mefit.user.entity.EnumStatus;
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
