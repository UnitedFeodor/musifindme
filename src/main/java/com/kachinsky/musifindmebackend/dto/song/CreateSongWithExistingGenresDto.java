package com.kachinsky.musifindmebackend.dto.song;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Song}
 */
@Value
public class CreateSongWithExistingGenresDto implements Serializable {
    @NotBlank(message = "Name must be not blank")
    String name;
    Set<Integer> genreIds;
    Set<Integer> artistIds;
}