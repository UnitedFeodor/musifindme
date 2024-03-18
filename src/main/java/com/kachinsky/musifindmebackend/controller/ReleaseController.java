package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.release.CreateReleaseWithExistingArtistsDto;
import com.kachinsky.musifindmebackend.dto.release.FlatReleaseWtihArtistsDto;
import com.kachinsky.musifindmebackend.dto.release.FullReleaseDto;
import com.kachinsky.musifindmebackend.dto.release.UpdateReleaseDto;
import com.kachinsky.musifindmebackend.service.ReleaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/releases")
@RequiredArgsConstructor
@Slf4j
public class ReleaseController {

    private final ReleaseService releaseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlatReleaseWtihArtistsDto> getAllReleases() {
        return releaseService.getAllReleases();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullReleaseDto getReleaseById(@PathVariable("id") int id) {
        return releaseService.getReleaseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullReleaseDto createReleaseWithExistingGenres(@RequestBody CreateReleaseWithExistingArtistsDto createReleaseDto) {
        return releaseService.createReleaseWithExistingGenres(createReleaseDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullReleaseDto updateRelease(
            @PathVariable("id") int id,
            @RequestBody UpdateReleaseDto createUpdateReleaseDto) {
        return releaseService.updateReleaseById(id, createUpdateReleaseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRelease(@PathVariable("id") int id) {
        releaseService.deleteReleaseById(id);
    }
}
