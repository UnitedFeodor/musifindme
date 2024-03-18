package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.song.CreateSongWithExistingGenresDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.song.FullSongDto;
import com.kachinsky.musifindmebackend.dto.song.UpdateSongDto;
import com.kachinsky.musifindmebackend.entity.Artist;
import com.kachinsky.musifindmebackend.entity.Genre;
import com.kachinsky.musifindmebackend.entity.Release;
import com.kachinsky.musifindmebackend.entity.Song;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ArtistDtoMapper.class, GenreDtoMapper.class, ReleaseDtoMapper.class})
public interface SongDtoMapper {
//    Song toEntity(SongDto songDto);

//    SongDto toDto(Song song);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Song partialUpdate(SongDto songDto, @MappingTarget Song song);

    Song toEntity(FlatSongDto flatSongDto);
    Song toEntity(CreateSongWithExistingGenresDto songDto);

    FlatSongDto toFlatDto(Song song);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Song partialUpdate(FlatSongDto flatSongDto, @MappingTarget Song song);

    Song toEntity(UpdateSongDto updateSongDto);

    @Mapping(target = "artistIds", expression = "java(artistsToArtistIds(song.getArtists()))")
    @Mapping(target = "genreIds", expression = "java(genresToGenreIds(song.getGenres()))")
    @Mapping(target = "releaseIds", expression = "java(releasesToReleaseIds(song.getReleases()))")
    UpdateSongDto toDto(Song song);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Song partialUpdate(UpdateSongDto updateSongDto, @MappingTarget Song song);

    default Set<Integer> artistsToArtistIds(Set<Artist> artists) {
        return artists.stream().map(Artist::getId).collect(Collectors.toSet());
    }

    default Set<Integer> genresToGenreIds(Set<Genre> genres) {
        return genres.stream().map(Genre::getId).collect(Collectors.toSet());
    }

    default Set<Integer> releasesToReleaseIds(Set<Release> releases) {
        return releases.stream().map(Release::getId).collect(Collectors.toSet());
    }

    Song toEntity(FullSongDto fullSongDto);

    FullSongDto toFullDto(Song song);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Song partialUpdate(FullSongDto fullSongDto, @MappingTarget Song song);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Song partialUpdate(FlatSongDto flatSongDto, @MappingTarget Song song);
}