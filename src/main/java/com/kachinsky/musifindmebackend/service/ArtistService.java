package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.mapper.ArtistDtoMapper;
import com.kachinsky.musifindmebackend.mapper.UserDtoMapper;
import com.kachinsky.musifindmebackend.repository.ArtistRepository;
import com.kachinsky.musifindmebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArtistService {

    private final ArtistDtoMapper artistDtoMapper;
    private final ArtistRepository artistRepository;

}
