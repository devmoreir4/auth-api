package com.example.authapi.dtos;

import com.example.authapi.enums.RoleEnum;

public record UserDto(String name,
                      String login,
                      String password,
                      RoleEnum role
) {
}
