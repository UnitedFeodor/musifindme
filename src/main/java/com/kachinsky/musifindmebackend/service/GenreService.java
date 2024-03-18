package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.genre.CreateUpdateGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.FlatGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.FullGenreDto;
import com.kachinsky.musifindmebackend.entity.Genre;
import com.kachinsky.musifindmebackend.exception.ResourceAlreadyExistsException;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.GenreDtoMapper;
import com.kachinsky.musifindmebackend.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreDtoMapper genreDtoMapper;

    @Transactional
    public List<FlatGenreDto> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genreDtoMapper.toDto(genres);
    }
    @Transactional
    public FullGenreDto getGenreById(Integer id) {
        Genre genre = getGenreByIdIfExists(id);
        return genreDtoMapper.toFullDto(genre);
    }
    @Transactional
    public FullGenreDto createGenre(CreateUpdateGenreDto genreDto) {
        String genreName = genreDto.getName();
        if (genreRepository.existsByName(genreName)) {
            throw new ResourceAlreadyExistsException("Genre with name " + genreName + " already exists");
        }

        Genre genreToCreate = genreDtoMapper.toEntity(genreDto);

        Genre createdGenre = genreRepository.save(genreToCreate);

        return genreDtoMapper.toFullDto(createdGenre);
    }
    @Transactional
    public FullGenreDto updateGenreById(int id, CreateUpdateGenreDto createUpdateGenreDto) {
        Genre genre = getGenreByIdIfExists(id);

        genreDtoMapper.partialUpdate(createUpdateGenreDto, genre);

        Genre updatedGenre = genreRepository.save(genre);
        return genreDtoMapper.toFullDto(updatedGenre);
    }
    @Transactional
    public void deleteGenre(int id) {
        Genre genre = getGenreByIdIfExists(id);

        genreRepository.delete(genre);
    }

    private Genre getGenreByIdIfExists(int id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
    }

}
