package com.example.authapi.services.impl;

import com.example.authapi.dtos.UserDto;
import com.example.authapi.models.User;
import com.example.authapi.repositories.UserRepository;
import com.example.authapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto salvar(UserDto userDto) {

        User userExist = userRepository.findByLogin(userDto.login());

        if (userExist != null){
            throw new RuntimeException("User already exists.");
        }

        var passwordHash = passwordEncoder.encode(userDto.password());

        User entity = new User(userDto.name(), userDto.login(), passwordHash, userDto.role());
        User newUser = userRepository.save(entity);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword(), newUser.getRole());
    }
}
