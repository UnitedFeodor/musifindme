package com.kachinsky.musifindmebackend.dto.instrument;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Instrument}
 */
@Value
public class CreateUpdateInstrumentDto implements Serializable {
    @NotBlank(message = "Name must be not blank")
    String name;
}