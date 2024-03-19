package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.artist.CreateArtistWithExistingGenresDto;
import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.dto.artist.FullArtistDto;
import com.kachinsky.musifindmebackend.dto.artist.UpdateArtistDto;
import com.kachinsky.musifindmebackend.entity.Artist;
import com.kachinsky.musifindmebackend.entity.Genre;
import com.kachinsky.musifindmebackend.entity.Release;
import com.kachinsky.musifindmebackend.entity.Song;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING, uses = {GenreDtoMapper.class, ReleaseDtoMapper.class, SongDtoMapper.class})
public interface ArtistDtoMapper {

    Artist toEntity(FlatArtistDto flatArtistDto);

    FlatArtistDto toFlatDto(Artist artist);

    List<FlatArtistDto> toDto(List<Artist> artist);

    Artist toEntity(CreateArtistWithExistingGenresDto createArtistWithExistingGenresDto);

    @Mapping(target = "genreIds", expression = "java(genresToGenreIds(artist.getGenres()))")
    CreateArtistWithExistingGenresDto toDto(Artist artist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Artist partialUpdate(CreateArtistWithExistingGenresDto createArtistWithExistingGenresDto, @MappingTarget Artist artist);

    default Set<Integer> genresToGenreIds(Set<Genre> genres) {
        return genres.stream().map(Genre::getId).collect(Collectors.toSet());
    }

    Artist toEntity(UpdateArtistDto updateArtistDto);

    @Mapping(target = "genreIds", expression = "java(genresToGenreIds(artist.getGenres()))")
    @Mapping(target = "releaseIds", expression = "java(releasesToReleaseIds(artist.getReleases()))")
    @Mapping(target = "songIds", expression = "java(songsToSongIds(artist.getSongs()))")
    UpdateArtistDto toUpadteDto(Artist artist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Artist partialUpdate(UpdateArtistDto updateArtistDto, @MappingTarget Artist artist);

    default Set<Integer> releasesToReleaseIds(Set<Release> releases) {
        return releases.stream().map(Release::getId).collect(Collectors.toSet());
    }

    default Set<Integer> songsToSongIds(Set<Song> songs) {
        return songs.stream().map(Song::getId).collect(Collectors.toSet());
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Artist partialUpdate(FlatArtistDto flatArtistDto, @MappingTarget Artist artist);

    Artist toEntity(FullArtistDto fullArtistDto);

    FullArtistDto toFullDto(Artist artist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Artist partialUpdate(FullArtistDto fullArtistDto, @MappingTarget Artist artist);


}