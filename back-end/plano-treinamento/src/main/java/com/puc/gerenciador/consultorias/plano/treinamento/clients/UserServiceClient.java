package com.puc.gerenciador.consultorias.plano.treinamento.clients;

import com.puc.gerenciador.consultorias.plano.treinamento.clients.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("user-service")
public interface UserServiceClient {

    @RequestMapping("/mefit/users")
    List<User> getUsers();

    @RequestMapping("/mefit/users/{statusId}/{userTypeId}")
    List<User> getUsersByStatusAndUserType(
            @PathVariable("statusId") Long statusId,
            @PathVariable("userTypeId") Long userTypeId
    );

}
