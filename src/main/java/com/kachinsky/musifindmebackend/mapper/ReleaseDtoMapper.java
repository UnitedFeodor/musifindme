package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.release.FlatReleaseDto;
import com.kachinsky.musifindmebackend.dto.release.FlatReleaseWtihArtistsDto;
import com.kachinsky.musifindmebackend.dto.release.FullReleaseDto;
import com.kachinsky.musifindmebackend.entity.Release;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ArtistDtoMapper.class, GenreDtoMapper.class, SongDtoMapper.class})
public interface ReleaseDtoMapper {
//    Release toEntity(FlatReleaseWithSongsDto releaseDto);

//    FlatReleaseWithSongsDto toDto(Release release);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Release partialUpdate(FlatReleaseWithSongsDto releaseDto, @MappingTarget Release release);

    Release toEntity(FlatReleaseDto flatReleaseDto);

    FlatReleaseDto toDto1(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FlatReleaseDto flatReleaseDto, @MappingTarget Release release);

    Release toEntity(FlatReleaseWtihArtistsDto flatReleaseWtihArtistsDto);

    FlatReleaseWtihArtistsDto toDto(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FlatReleaseWtihArtistsDto flatReleaseWtihArtistsDto, @MappingTarget Release release);

    Release toEntity(FullReleaseDto fullReleaseDto);

    FullReleaseDto toDto2(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FullReleaseDto fullReleaseDto, @MappingTarget Release release);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Release partialUpdate(FlatReleaseDto flatReleaseDto, @MappingTarget Release release);
}