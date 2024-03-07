package com.kachinsky.musifindmebackend.dto;

import com.kachinsky.musifindmebackend.entity.Song;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Song}
 */
@Value
public class FlatSongDto implements Serializable {
    Integer id;
    String name;
}