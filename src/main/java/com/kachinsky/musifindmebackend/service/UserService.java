package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.FullUserDto;
import com.kachinsky.musifindmebackend.entity.User;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.UserDtoMapper;
import com.kachinsky.musifindmebackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;

    @Transactional
    public FlatUserDto getFullUserById(int id) {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(ResourceNotFoundException::new);
//        user.getArtists();
//        user.getInstruments();


        return userDtoMapper.toFlatUserDto(user);
    }
}
