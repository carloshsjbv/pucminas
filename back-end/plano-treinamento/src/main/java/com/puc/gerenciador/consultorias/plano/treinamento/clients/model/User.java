package com.puc.gerenciador.consultorias.plano.treinamento.clients.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private Long id;

    private String login;

    private String nome;

    private Integer status;

    private UserType userType;

}
