package com.kachinsky.musifindmebackend.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ErrorResponse {
    private final int statusCode;
    private final String message;
}
