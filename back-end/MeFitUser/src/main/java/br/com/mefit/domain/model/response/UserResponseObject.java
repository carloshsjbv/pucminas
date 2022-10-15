package br.com.mefit.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseObject implements Serializable {

    private Long id;

    private String login;

    private String nome;

    private Integer status;

    private UserTypeResponseObject userTypeResponseObject;

}
