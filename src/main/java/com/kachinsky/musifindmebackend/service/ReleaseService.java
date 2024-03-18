package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.release.*;
import com.kachinsky.musifindmebackend.entity.Release;
import com.kachinsky.musifindmebackend.exception.ResourceAlreadyExistsException;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.ReleaseDtoMapper;
import com.kachinsky.musifindmebackend.repository.ReleaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// TODO fix entity constraints like releases requiring genres to be consistent and flexible
@Service
@RequiredArgsConstructor
@Slf4j
public class ReleaseService {
    private final ReleaseDtoMapper releaseDtoMapper;
    private final ReleaseRepository releaseRepository;

    @Transactional
    public List<FlatReleaseWtihArtistsDto> getAllReleases() {
        List<FlatReleaseWtihArtistsDto> flatReleaseDtos = releaseRepository.findAll().stream()
                .map(releaseDtoMapper::toFlatWithArtistsDto)
                .collect(Collectors.toList());
        return flatReleaseDtos;
    }
    @Transactional
    public FullReleaseDto getReleaseById(int id) {
        return releaseRepository.findById(id)
                .map(releaseDtoMapper::toFullDto)
                .orElseThrow(() -> new ResourceNotFoundException("Release with id " + id + " not found"));
    }
    @Transactional
    public FullReleaseDto createReleaseWithExistingGenres(CreateReleaseWithExistingArtistsDto releaseDto) {
        String releaseName = releaseDto.getName();
        Set<Integer> releaseArtistIds = releaseDto.getArtistIds();
        if (releaseRepository.existsByNameAndArtists(releaseName,releaseArtistIds)) {
            throw new ResourceAlreadyExistsException("Release with name " + releaseName + " and artists " + releaseArtistIds + " already exists");
        }

        Release releaseToCreate = releaseDtoMapper.toEntity(releaseDto);

        Release createdRelease = releaseRepository.save(releaseToCreate);

        return releaseDtoMapper.toFullDto(createdRelease);
    }

    // TODO sort out dtomapper method names
    @Transactional
    public FullReleaseDto updateReleaseById(int id, UpdateReleaseDto createUpdateReleaseDto) {
        return releaseRepository.findById(id)
                .map(release -> {
                    releaseDtoMapper.partialUpdate(createUpdateReleaseDto, release);
                    return releaseDtoMapper.toFullDto(releaseRepository.save(release));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Release with id " + id + " not found"));
    }
    @Transactional
    public void deleteReleaseById(int id) {
        if (!releaseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Release with id " + id + " not found");
        }
        releaseRepository.deleteById(id);
        log.info("Release with id {} deleted", id);
    }
}
