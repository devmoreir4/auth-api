package com.example.authapi.dtos;

import lombok.Builder;

@Builder
public record TokenResponseDto(String token, String refreshToken) {
}
