package com.kachinsky.musifindmebackend.dto.artist;

import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.dto.release.FlatReleaseDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Artist}
 */
@Value
public class FullArtistDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must not be empty")
    String name;
    Set<FlatGenreDto> genres;
    Set<FlatReleaseDto> releases;
    Set<FlatSongDto> songs;
    Set<FlatUserDto> users;
}