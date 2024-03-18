package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.genre.CreateUpdateGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.GenreDto;
import com.kachinsky.musifindmebackend.entity.Genre;
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
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genreDtoMapper.toDto(genres);
    }
    @Transactional
    public GenreDto getGenreById(Integer id) {
        Genre genre = getGenreByIdIfExists(id);
        return genreDtoMapper.toDto(genre);
    }
    @Transactional
    public GenreDto createGenre(CreateUpdateGenreDto createUpdateGenreDto) {
        Genre genre = genreDtoMapper.toEntity(createUpdateGenreDto);
        Genre savedGenre = genreRepository.save(genre);
        return genreDtoMapper.toDto(savedGenre);
    }
    @Transactional
    public GenreDto updateGenre(int id, CreateUpdateGenreDto createUpdateGenreDto) {
        Genre genre = getGenreByIdIfExists(id);

        genreDtoMapper.partialUpdate(createUpdateGenreDto, genre);

        Genre updatedGenre = genreRepository.save(genre);
        return genreDtoMapper.toDto(updatedGenre);
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
