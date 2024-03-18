package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.release.*;
import com.kachinsky.musifindmebackend.entity.Artist;
import com.kachinsky.musifindmebackend.entity.Genre;
import com.kachinsky.musifindmebackend.entity.Release;
import com.kachinsky.musifindmebackend.entity.Song;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

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

    FlatReleaseWtihArtistsDto toFlatWithArtistsDto(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FlatReleaseWtihArtistsDto flatReleaseWtihArtistsDto, @MappingTarget Release release);

    Release toEntity(FullReleaseDto fullReleaseDto);

    FullReleaseDto toFullDto(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(FullReleaseDto fullReleaseDto, @MappingTarget Release release);

    Release toEntity(CreateReleaseWithExistingArtistsDto createReleaseWithExistingArtistsDto);

    @Mapping(target = "artistIds", expression = "java(artistsToArtistIds(release.getArtists()))")
    CreateReleaseWithExistingArtistsDto toDto3(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(CreateReleaseWithExistingArtistsDto createReleaseWithExistingArtistsDto, @MappingTarget Release release);

    default Set<Integer> artistsToArtistIds(Set<Artist> artists) {
        return artists.stream().map(Artist::getId).collect(Collectors.toSet());
    }

    Release toEntity(UpdateReleaseDto updateReleaseDto);

    @Mapping(target = "artistIds", expression = "java(artistsToArtistIds(release.getArtists()))")
    @Mapping(target = "genreIds", expression = "java(genresToGenreIds(release.getGenres()))")
    @Mapping(target = "songIds", expression = "java(songsToSongIds(release.getSongs()))")
    UpdateReleaseDto toDto4(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Release partialUpdate(UpdateReleaseDto updateReleaseDto, @MappingTarget Release release);

    default Set<Integer> genresToGenreIds(Set<Genre> genres) {
        return genres.stream().map(Genre::getId).collect(Collectors.toSet());
    }

    default Set<Integer> songsToSongIds(Set<Song> songs) {
        return songs.stream().map(Song::getId).collect(Collectors.toSet());
    }

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Release partialUpdate(FlatReleaseDto flatReleaseDto, @MappingTarget Release release);
}