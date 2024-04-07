package com.example.authapi.controllers;

import com.example.authapi.dtos.UserDto;
import com.example.authapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto salvar(@RequestBody UserDto userDto){
        return userService.salvar(userDto);
    }

}
