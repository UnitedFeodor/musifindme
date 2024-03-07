package com.kachinsky.musifindmebackend.dto;

import com.kachinsky.musifindmebackend.entity.Instrument;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Instrument}
 */
@Value
public class InstrumentDto implements Serializable {
    Integer id;
    String name;
}