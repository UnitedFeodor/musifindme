package com.kachinsky.musifindmebackend.dto.song;

import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.entity.Song;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Song}
 */
@Value
public class SongDto implements Serializable {
    Integer id;
    String name;
    Set<FlatGenreDto> genres;
}