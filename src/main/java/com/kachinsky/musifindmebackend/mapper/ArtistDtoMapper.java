package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.entity.Artist;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ArtistDtoMapper {

//    Artist toEntity(ArtistDto artistDto);
//    ArtistDto toArtistDto(Artist artist);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Artist partialUpdate(ArtistDto artistDto, @MappingTarget Artist artist);

    Artist toEntity(FlatArtistDto flatArtistDto);

    FlatArtistDto toFlatArtistDto(Artist artist);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Artist partialUpdate(FlatArtistDto flatArtistDto, @MappingTarget Artist artist);
}