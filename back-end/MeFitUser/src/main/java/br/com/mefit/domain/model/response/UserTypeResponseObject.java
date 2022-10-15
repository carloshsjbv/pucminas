package br.com.mefit.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTypeResponseObject implements Serializable {

    private Long id;

    private String nome;

}
