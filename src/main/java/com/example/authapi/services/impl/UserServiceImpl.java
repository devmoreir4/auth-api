package com.example.authapi.services.impl;

import com.example.authapi.dtos.UserDto;
import com.example.authapi.models.User;
import com.example.authapi.respositories.UserRepository;
import com.example.authapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto salvar(UserDto userDto) {

        User userExist = userRepository.findByLogin(userDto.login());

        if (userExist != null){
            throw new RuntimeException("User already exists.");
        }

        User entity = new User(userDto.name(), userDto.login(), userDto.password());
        User newUser = userRepository.save(entity);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword());
    }
}
