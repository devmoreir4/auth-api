package com.example.authapi.services;

import com.example.authapi.dtos.AuthDto;
import com.example.authapi.dtos.TokenResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    public TokenResponseDto obterToken(AuthDto authDto);
    public String validaTokenJwt(String token);

    TokenResponseDto obterRefreshToken(String s);

}
