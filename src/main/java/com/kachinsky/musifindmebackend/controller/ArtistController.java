package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.artist.*;
import com.kachinsky.musifindmebackend.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
@Slf4j
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlatArtistDto> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullArtistDto getArtistById(@PathVariable("id") int id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullArtistDto createArtistWithExistingGenres(@RequestBody CreateArtistWithExistingGenresDto createArtistDto) {
        return artistService.createArtistWithExistingGenres(createArtistDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullArtistDto updateArtist(
            @PathVariable("id") int id,
            @RequestBody UpdateArtistDto createUpdateArtistDto) {
        return artistService.updateArtistById(id, createUpdateArtistDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable("id") int id) {
        artistService.deleteArtistById(id);
    }


}
