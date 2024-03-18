package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.genre.CreateUpdateGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.GenreDto;
import com.kachinsky.musifindmebackend.entity.Genre;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreDtoMapper {
    Genre toEntity(GenreDto genreDto);
    Genre toEntity(CreateUpdateGenreDto genreDto);

    GenreDto toDto(Genre genre);

    List<GenreDto> toDto(List<Genre> genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(CreateUpdateGenreDto genreDto, @MappingTarget Genre genre);
}