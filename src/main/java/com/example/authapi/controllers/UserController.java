package com.example.authapi.controllers;

import com.example.authapi.dtos.UserDto;
import com.example.authapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto salvar(@RequestBody UserDto userDto){
        return userService.salvar(userDto);
    }

    @GetMapping("/admin")
    private String getAdmin() {
        return "admin permission.";
    }

    @GetMapping("/user")
    private String getUser() {
        return "user permission.";
    }

}
