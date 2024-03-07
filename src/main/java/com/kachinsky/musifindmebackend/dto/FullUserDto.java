package com.kachinsky.musifindmebackend.dto;

import com.kachinsky.musifindmebackend.entity.User;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * DTO for {@link User}
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
    Set<ArtistDto> artists;
    Set<InstrumentDto> instruments;
}