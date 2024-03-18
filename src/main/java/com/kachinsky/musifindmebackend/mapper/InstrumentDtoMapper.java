package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.instrument.CreateUpdateInstrumentDto;
import com.kachinsky.musifindmebackend.entity.Instrument;
import com.kachinsky.musifindmebackend.dto.instrument.InstrumentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InstrumentDtoMapper {
    Instrument toEntity(InstrumentDto instrumentDto);

    Instrument toEntity(CreateUpdateInstrumentDto instrumentDto);
    InstrumentDto toDto(Instrument instrument);
    List<InstrumentDto> toDto(List<Instrument> instrument);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Instrument partialUpdate(CreateUpdateInstrumentDto instrumentDto, @MappingTarget Instrument instrument);
}