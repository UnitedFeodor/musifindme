package com.kachinsky.musifindmebackend.dto.release;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Release}
 */
@Value
public class FullReleaseDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must be not blank")
    String name;
    @NotBlank(message = "Release type must be not blank")
    String releaseType;
    @Min(message = "Release must no be negative", value = 0)
    Integer releaseYear;
    @NotBlank(message = "Record label must be not blank")
    String recordLabel;
    @NotBlank(message = "Producer must be not blank")
    String producer;
    @NotBlank(message = "Cover image url must be not blank")
    String coverImageUrl;
    String description;
    Set<FlatArtistDto> artists;
    Set<FlatGenreDto> genres;
    Set<FlatSongDto> songs;
    Set<FlatUserDto> users;
}