package com.kachinsky.musifindmebackend.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class ErrorResponse {
    private final int statusCode;
    private final String message;
}
