package com.kachinsky.musifindmebackend.dto.release;

import com.kachinsky.musifindmebackend.entity.Release;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Release}
 */
@Value
public class FlatReleaseDto implements Serializable {
    Integer id;
    String name;
    String releaseType;
    Integer releaseYear;
    String coverImageUrl;
}