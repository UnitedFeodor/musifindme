package com.kachinsky.musifindmebackend.dto.release;

import com.kachinsky.musifindmebackend.entity.Release;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Release}
 */
@Value
public class FlatReleaseDto implements Serializable {
    Integer id;
    String name;
    String releaseType;
    Integer releaseYear;
    String recordLabel;
    String producer;
    String coverImageUrl;
    String description;
}