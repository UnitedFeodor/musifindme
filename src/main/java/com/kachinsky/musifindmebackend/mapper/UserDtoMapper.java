package com.kachinsky.musifindmebackend.mapper;

import com.kachinsky.musifindmebackend.dto.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.UpdateUserDto;
import com.kachinsky.musifindmebackend.entity.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = MappingConstants.ComponentModel.SPRING
//        uses = {ArtistDtoMapper.class, InstrumentDtoMapper.class, GenreDtoMapper.class, ReleaseDtoMapper.class, SongDtoMapper.class}
)
public interface UserDtoMapper {
//    @Mapping(source = "socials", target = "socialsJson")
//    User toUser(FullUserDto fullUserDto);
//
//    @Mapping(source = "socialsJson", target = "socials")
//    FullUserDto toFullUserDto(User user);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(source = "socials", target = "socialsJson")
//    User partialUpdate(FullUserDto fullUserDto, @MappingTarget User user);

    @Mapping(source = "socials", target = "socialsJson")
    User toUser(FlatUserDto flatUserDto);


    @Mapping(source = "socialsJson", target = "socials")
    FlatUserDto toFlatUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(FlatUserDto flatUserDto, @MappingTarget User user);

    User toEntity(UpdateUserDto updateUserDto);

    @Mapping(target = "artists", expression = "java(artistsToArtistIds(user.getArtists()))")
    @Mapping(target = "genres", expression = "java(genresToGenreIds(user.getGenres()))")
    @Mapping(target = "instruments", expression = "java(instrumentsToInstrumentIds(user.getInstruments()))")
    @Mapping(target = "releases", expression = "java(releasesToReleaseIds(user.getReleases()))")
    @Mapping(target = "songs", expression = "java(songsToSongIds(user.getSongs()))")
    UpdateUserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "socials", target = "socialsJson")
    User partialUpdate(UpdateUserDto updateUserDto, @MappingTarget User user);

    User toEntity(CreateUserDto createUserDto);

    @Mapping(target = "artistIds", expression = "java(artistsToArtistIds(user.getArtists()))")
    @Mapping(target = "genreIds", expression = "java(genresToGenreIds(user.getGenres()))")
    @Mapping(target = "instrumentIds", expression = "java(instrumentsToInstrumentIds(user.getInstruments()))")
    @Mapping(target = "releaseIds", expression = "java(releasesToReleaseIds(user.getReleases()))")
    @Mapping(target = "songIds", expression = "java(songsToSongIds(user.getSongs()))")
    CreateUserDto toCreateUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "socials", target = "socialsJson")
    User partialUpdate(CreateUserDto createUserDto, @MappingTarget User user);

    default Set<Integer> artistsToArtistIds(Set<Artist> artists) {
        return artists.stream().map(Artist::getId).collect(Collectors.toSet());
    }

    default Set<Integer> genresToGenreIds(Set<Genre> genres) {
        return genres.stream().map(Genre::getId).collect(Collectors.toSet());
    }

    default Set<Integer> instrumentsToInstrumentIds(Set<Instrument> instruments) {
        return instruments.stream().map(Instrument::getId).collect(Collectors.toSet());
    }

    default Set<Integer> releasesToReleaseIds(Set<Release> releases) {
        return releases.stream().map(Release::getId).collect(Collectors.toSet());
    }

    default Set<Integer> songsToSongIds(Set<Song> songs) {
        return songs.stream().map(Song::getId).collect(Collectors.toSet());
    }

    default Set<Artist> artistIdsToArtists(Set<Integer> artistIds) {
        if (artistIds == null) {
            return null;
        }
        return artistIds.stream()
                .map(id -> {
                    Artist artist = new Artist();
                    artist.setId(id);
                    return artist;
                })
                .collect(Collectors.toSet());
    }

    default Set<Genre> genreIdsToGenres(Set<Integer> genreIds) {
        if (genreIds == null) {
            return null;
        }
        return genreIds.stream()
                .map(id -> {
                    Genre genre = new Genre();
                    genre.setId(id);
                    return genre;
                })
                .collect(Collectors.toSet());
    }

    default Set<Instrument> instrumentIdsToInstruments(Set<Integer> instrumentIds) {
        if (instrumentIds == null) {
            return null;
        }
        return instrumentIds.stream()
                .map(id -> {
                    Instrument instrument = new Instrument();
                    instrument.setId(id);
                    return instrument;
                })
                .collect(Collectors.toSet());
    }

    default Set<Release> releaseIdsToReleases(Set<Integer> releaseIds) {
        if (releaseIds == null) {
            return null;
        }
        return releaseIds.stream()
                .map(id -> {
                    Release release = new Release();
                    release.setId(id);
                    return release;
                })
                .collect(Collectors.toSet());
    }

    default Set<Song> songIdsToSongs(Set<Integer> songIds) {
        if (songIds == null) {
            return null;
        }
        return songIds.stream()
                .map(id -> {
                    Song song = new Song();
                    song.setId(id);
                    return song;
                })
                .collect(Collectors.toSet());
    }
}