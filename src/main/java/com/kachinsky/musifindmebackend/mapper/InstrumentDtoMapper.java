package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.entity.Instrument;
import com.kachinsky.musifindmebackend.dto.InstrumentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InstrumentDtoMapper {
    Instrument toEntity(InstrumentDto instrumentDto);

    InstrumentDto toDto(Instrument instrument);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Instrument partialUpdate(InstrumentDto instrumentDto, @MappingTarget Instrument instrument);
}