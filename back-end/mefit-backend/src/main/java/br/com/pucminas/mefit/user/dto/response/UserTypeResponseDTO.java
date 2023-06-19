package br.com.pucminas.mefit.user.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserTypeResponseDTO {

    private Long id;

    private String nome;

}
