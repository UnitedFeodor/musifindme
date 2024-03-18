package com.kachinsky.musifindmebackend.dto.artist;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Artist}
 */
@Value
public class CreateArtistWithExistingGenresDto implements Serializable {
    @NotBlank(message = "Name must not be empty")
    String name;
    Set<Integer> genreIds;
}