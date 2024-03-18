package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.artist.CreateArtistWithExistingGenresDto;
import com.kachinsky.musifindmebackend.dto.artist.FlatArtistDto;
import com.kachinsky.musifindmebackend.dto.artist.FullArtistDto;
import com.kachinsky.musifindmebackend.dto.artist.UpdateArtistDto;
import com.kachinsky.musifindmebackend.entity.Artist;
import com.kachinsky.musifindmebackend.exception.ResourceAlreadyExistsException;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.ArtistDtoMapper;
import com.kachinsky.musifindmebackend.repository.ArtistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistService {

    private final ArtistDtoMapper artistDtoMapper;
    private final ArtistRepository artistRepository;

    @Transactional
    public List<FlatArtistDto> getAllArtists() {
        List<Artist> artists = artistRepository.findAll();
        return artistDtoMapper.toDto(artists);
    }

    @Transactional
    public FullArtistDto createArtistWithExistingGenres(CreateArtistWithExistingGenresDto artistDto) {
        String artistName = artistDto.getName();
        if (artistRepository.existsByName(artistName)) {
            throw new ResourceAlreadyExistsException("Artist with name " + artistName + " already exists");
        }

        Artist artistToCreate = artistDtoMapper.toEntity(artistDto);

        Artist createdArtist = artistRepository.save(artistToCreate);

        return artistDtoMapper.toFullDto(createdArtist);
    }

    @Transactional
    public FullArtistDto updateArtistById(int id, UpdateArtistDto createUpdateArtistDto) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist with id " + id + " not found"));
        artistDtoMapper.partialUpdate(createUpdateArtistDto, artist);
        Artist updatedArtist = artistRepository.save(artist);
        return artistDtoMapper.toFullDto(updatedArtist);
    }

    @Transactional
    public FullArtistDto getArtistById(int id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist with id " + id + " not found"));
        return artistDtoMapper.toFullDto(artist);
    }

    @Transactional
    public void deleteArtistById(int id) {
        if (!artistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Artist with id " + id + " not found");
        }
        artistRepository.deleteById(id);
        log.info("Artist with id {} deleted", id);
    }
}
