package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.song.CreateSongWithExistingGenresDto;
import com.kachinsky.musifindmebackend.dto.song.FlatSongDto;
import com.kachinsky.musifindmebackend.dto.song.FullSongDto;
import com.kachinsky.musifindmebackend.dto.song.UpdateSongDto;
import com.kachinsky.musifindmebackend.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
@Slf4j
public class SongController {

    private final SongService songService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlatSongDto> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullSongDto getSongById(@PathVariable("id") int id) {
        return songService.getSongById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullSongDto createSongWithExistingGenres(@RequestBody CreateSongWithExistingGenresDto createSongDto) {
        return songService.createSongWithExistingGenres(createSongDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullSongDto updateSong(
            @PathVariable("id") int id,
            @RequestBody UpdateSongDto createUpdateSongDto) {
        return songService.updateSongById(id, createUpdateSongDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable("id") int id) {
        songService.deleteSongById(id);
    }
    
}
