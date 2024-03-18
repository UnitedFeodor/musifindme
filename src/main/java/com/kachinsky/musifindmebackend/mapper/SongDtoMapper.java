package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.entity.Song;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SongDtoMapper {
//    Song toEntity(SongDto songDto);

//    SongDto toDto(Song song);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Song partialUpdate(SongDto songDto, @MappingTarget Song song);

    Song toEntity(FlatSongDto flatSongDto);

    FlatSongDto toDto1(Song song);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Song partialUpdate(FlatSongDto flatSongDto, @MappingTarget Song song);
}