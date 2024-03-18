package com.kachinsky.musifindmebackend.dto.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.User}
 */
@Value
public class FlatUserDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must not be empty")
    String name;
    @Min(message = "User age must be at least 12", value = 12)
    @Max(message = "User age is too old", value = 100)
    Integer age;
    @NotBlank(message = "City must not be empty")
    String city;
}