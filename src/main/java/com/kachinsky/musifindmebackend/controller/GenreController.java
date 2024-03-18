package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.genre.CreateUpdateGenreDto;
import com.kachinsky.musifindmebackend.dto.genre.GenreDto;
import com.kachinsky.musifindmebackend.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
@Slf4j
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GenreDto> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreDto getGenreById(@PathVariable("id") int id) {
        return genreService.getGenreById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDto createGenre(@RequestBody CreateUpdateGenreDto createUpdateGenreDto) {
        return genreService.createGenre(createUpdateGenreDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreDto updateGenre(
            @PathVariable("id") Integer id,
            @RequestBody CreateUpdateGenreDto createUpdateGenreDto) {
        return genreService.updateGenre(id, createUpdateGenreDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGenre(@PathVariable("id") Integer id) {
        genreService.deleteGenre(id);
    }
    
}