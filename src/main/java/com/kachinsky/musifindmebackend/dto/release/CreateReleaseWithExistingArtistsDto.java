package com.kachinsky.musifindmebackend.dto.release;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Release}
 */
@Value
public class CreateReleaseWithExistingArtistsDto implements Serializable {
    @NotBlank(message = "Name must be not blank")
    String name;
    @Min(message = "Release must no be negative", value = 0)
    Integer releaseYear;
    @NotBlank(message = "Record label must be not blank")
    String recordLabel;
    @NotBlank(message = "Producer must be not blank")
    String producer;
    @NotBlank(message = "Cover image url must be not blank")
    String coverImageUrl;
    String description;
    Set<Integer> artistIds;
}