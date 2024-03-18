package com.kachinsky.musifindmebackend.dto.instrument;

import com.kachinsky.musifindmebackend.entity.Instrument;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Instrument}
 */
@Value
public class FlatInstrumentDto implements Serializable {
    Integer id;
    String name;
}