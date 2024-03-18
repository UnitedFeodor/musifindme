package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.song.CreateSongWithExistingGenresDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.song.FullSongDto;
import com.kachinsky.musifindmebackend.dto.song.UpdateSongDto;
import com.kachinsky.musifindmebackend.entity.Song;
import com.kachinsky.musifindmebackend.exception.ResourceAlreadyExistsException;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.SongDtoMapper;
import com.kachinsky.musifindmebackend.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongService {

    private final SongDtoMapper songDtoMapper;
    private final SongRepository songRepository;

    @Transactional
    public List<FlatSongDto> getAllSongs() {
        List<FlatSongDto> flatSongDtos = songRepository.findAll().stream()
                .map(songDtoMapper::toFlatDto)
                .collect(Collectors.toList());
        return flatSongDtos;
    }
    @Transactional
    public FullSongDto getSongById(int id) {
        return songRepository.findById(id)
                .map(songDtoMapper::toFullDto)
                .orElseThrow(() -> new ResourceNotFoundException("Song with id " + id + " not found"));
    }
    @Transactional
    public FullSongDto createSongWithExistingGenres(CreateSongWithExistingGenresDto songDto) {
        String songName = songDto.getName();
        Set<Integer> songArtistIds = songDto.getArtistIds();
        if (songRepository.existsByNameAndArtists(songName,songArtistIds)) {
            throw new ResourceAlreadyExistsException("Song with name " + songName + " and artists " + songArtistIds + " already exists");
        }

        Song songToCreate = songDtoMapper.toEntity(songDto);

        Song createdSong = songRepository.save(songToCreate);

        return songDtoMapper.toFullDto(createdSong);
    }

    // TODO sort out dtomapper method names
    @Transactional
    public FullSongDto updateSongById(int id, UpdateSongDto createUpdateSongDto) {
        return songRepository.findById(id)
                .map(song -> {
                    songDtoMapper.partialUpdate(createUpdateSongDto, song);
                    return songDtoMapper.toFullDto(songRepository.save(song));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Song with id " + id + " not found"));
    }
    @Transactional
    public void deleteSongById(int id) {
        if (!songRepository.existsById(id)) {
            throw new ResourceNotFoundException("Song with id " + id + " not found");
        }
        songRepository.deleteById(id);
        log.info("Song with id {} deleted", id);
    }
}
