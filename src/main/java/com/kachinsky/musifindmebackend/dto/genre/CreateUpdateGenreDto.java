package com.kachinsky.musifindmebackend.dto.genre;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Genre}
 */
@Value
public class CreateUpdateGenreDto implements Serializable {
    @NotBlank(message = "Name must be not blank")
    String name;
}