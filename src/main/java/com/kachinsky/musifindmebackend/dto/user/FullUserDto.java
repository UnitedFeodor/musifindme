package com.kachinsky.musifindmebackend.dto.user;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.dto.instrument.FlatInstrumentDto;
import com.kachinsky.musifindmebackend.dto.release.FlatReleaseDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.User}
 */
@Value
public class FullUserDto implements Serializable {
    Integer id;
    String name;
    Integer age;
    String city;
    String description;
    String searchingFor;
    Map<String, String> socials;
    String email;
    Set<FlatArtistDto> artists;
    Set<FlatGenreDto> genres;
    Set<FlatInstrumentDto> instruments;
    Set<FlatReleaseDto> releases;
    Set<FlatSongDto> songs;
}