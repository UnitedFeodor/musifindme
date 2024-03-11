package com.kachinsky.musifindmebackend.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.User}
 */
@Value
public class FlatUserDto implements Serializable {
    Integer id;
    String name;
    Integer age;
    String city;
    String description;
    String searchingFor;
    Map<String, String> socials;
    String email;
    Set<FlatArtistDto> artists;
    Set<GenreDto> genres;
    Set<InstrumentDto> instruments;
    Set<FlatReleaseDto> releases;
    Set<FlatSongDto> songs;
}