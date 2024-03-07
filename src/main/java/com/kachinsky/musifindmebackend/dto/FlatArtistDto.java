package com.kachinsky.musifindmebackend.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Artist}
 */
@Value
public class FlatArtistDto implements Serializable {
    Integer id;
    String name;
}