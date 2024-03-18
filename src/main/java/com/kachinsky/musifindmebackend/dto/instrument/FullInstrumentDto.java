package com.kachinsky.musifindmebackend.dto.instrument;

import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import com.kachinsky.musifindmebackend.entity.Instrument;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Instrument}
 */
@Value
public class FullInstrumentDto implements Serializable {
    Integer id;
    @NotBlank(message = "Name must be not blank")
    String name;
    Set<FlatUserDto> users;
}