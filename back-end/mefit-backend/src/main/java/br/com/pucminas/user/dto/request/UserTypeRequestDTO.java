package br.com.pucminas.user.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserTypeRequestDTO {

    private Long id;

    private String nome;

}
