package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.instrument.CreateUpdateInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FlatInstrumentDto;
import com.kachinsky.musifindmebackend.dto.instrument.FullInstrumentDto;
import com.kachinsky.musifindmebackend.entity.Instrument;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InstrumentDtoMapper {
    Instrument toEntity(FlatInstrumentDto flatInstrumentDto);

    Instrument toEntity(CreateUpdateInstrumentDto instrumentDto);
    FlatInstrumentDto toDto(Instrument instrument);
    FullInstrumentDto toFullDto(Instrument instrument);
    List<FlatInstrumentDto> toDto(List<Instrument> instrument);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Instrument partialUpdate(CreateUpdateInstrumentDto instrumentDto, @MappingTarget Instrument instrument);
}