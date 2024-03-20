package com.kachinsky.musifindmebackend.dto.song;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Song}
 */
@Value
public class FlatSongWithArtistsDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must be not blank")
    String name;
    Set<FlatArtistDto> artists;
}