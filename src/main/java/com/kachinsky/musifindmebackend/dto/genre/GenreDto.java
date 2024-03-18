package com.kachinsky.musifindmebackend.dto.genre;

import com.kachinsky.musifindmebackend.entity.Genre;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Genre}
 */
@Value
public class GenreDto implements Serializable {
    Integer id;
    String name;
}