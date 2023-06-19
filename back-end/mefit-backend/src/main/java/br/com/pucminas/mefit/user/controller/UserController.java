package br.com.pucminas.user.controller;

import br.com.pucminas.user.dto.request.UserRequestDTO;
import br.com.pucminas.user.dto.response.UserResponseDTO;
import br.com.pucminas.user.entity.EnumStatus;
import br.com.pucminas.user.mapper.UserMapper;
import br.com.pucminas.user.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(final UserService service) {
        this.userService = service;
        this.mapper = UserMapper.INSTANCE;
    }

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return mapper.convertList(userService.findAll());
    }


    @PostMapping
    public UserResponseDTO save(@RequestBody final UserRequestDTO user) {
        return mapper.convert(userService.save(user));
    }

    @PutMapping(value = "/{userId}")
    public UserResponseDTO updateUser(@PathVariable("userId") final Long userId, @RequestBody final UserRequestDTO request) {
        return mapper.convert(userService.update(userId, request));
    }

    @DeleteMapping(value = "/{userId}")
    public void remover(@PathVariable("userId") Long userId) {
        userService.remove(userId);
    }

    @GetMapping(value = "/{login}")
    public UserResponseDTO findByLogin(@PathVariable("login") final String login) {
       return mapper.convert(userService.findUserByLogin(login));
    }

    @GetMapping(value = "/{status}/{userTypeId}")
    public List<UserResponseDTO> findUsersByStatusAndUserTypeId(@PathVariable("status") final EnumStatus status, @PathVariable("userTypeId") final Long userTypeId) {
        return mapper.convertList(userService.findUsersByStatusAndUserTypeId(status, userTypeId));
    }


}