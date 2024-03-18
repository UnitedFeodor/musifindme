package com.kachinsky.musifindmebackend.dto.release;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Release}
 */
@Value
public class FlatReleaseWtihArtistsDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must be not blank")
    String name;
    @NotBlank(message = "Release type must be not blank")
    String releaseType;
    @Min(message = "Release must no be negative", value = 0)
    Integer releaseYear;
    @NotBlank(message = "Cover image url must be not blank")
    String coverImageUrl;
    Set<FlatArtistDto> artists;
}