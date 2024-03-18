package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.genre.GenreDto;
import com.kachinsky.musifindmebackend.entity.Genre;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreDtoMapper {
    Genre toEntity(GenreDto genreDto);

    GenreDto toDto(Genre genre);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Genre partialUpdate(GenreDto genreDto, @MappingTarget Genre genre);
}