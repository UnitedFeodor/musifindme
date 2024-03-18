package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.release.FlatReleaseDto;
import com.kachinsky.musifindmebackend.entity.Release;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReleaseDtoMapper {
//    Release toEntity(ReleaseDto releaseDto);

//    ReleaseDto toDto(Release release);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Release partialUpdate(ReleaseDto releaseDto, @MappingTarget Release release);

    Release toEntity(FlatReleaseDto flatReleaseDto);

    FlatReleaseDto toDto1(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FlatReleaseDto flatReleaseDto, @MappingTarget Release release);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Release partialUpdate(FlatReleaseDto flatReleaseDto, @MappingTarget Release release);
}