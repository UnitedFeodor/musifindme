package com.kachinsky.musifindmebackend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

@Value
public class LoginRequestDto implements Serializable {
    String email;
    String password;
}
