package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.genre.CreateUpdateGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.FullGenreDto;
import com.kachinsky.musifindmebackend.entity.Genre;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreDtoMapper {
    Genre toEntity(FlatGenreDto flatGenreDto);

    Genre toEntity(CreateUpdateGenreDto genreDto);

    FlatGenreDto toDto(Genre genre);

    FullGenreDto toFullDto(Genre genre);

    List<FlatGenreDto> toDto(List<Genre> genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(CreateUpdateGenreDto genreDto, @MappingTarget Genre genre);

    Genre toEntity(FullGenreDto fullGenreDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(FullGenreDto fullGenreDto, @MappingTarget Genre genre);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Genre partialUpdate(FlatGenreDto flatGenreDto, @MappingTarget Genre genre);
}