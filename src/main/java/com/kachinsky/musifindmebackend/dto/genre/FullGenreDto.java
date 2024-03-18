package com.kachinsky.musifindmebackend.dto.genre;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.dto.release.FlatReleaseDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Genre}
 */
@Value
public class FullGenreDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must be not blank")
    String name;
    Set<FlatArtistDto> artists;
    Set<FlatReleaseDto> releases;
    Set<FlatSongDto> songs;
    Set<FlatUserDto> users;
}