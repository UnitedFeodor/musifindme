package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.UpdateUserDto;
import com.kachinsky.musifindmebackend.entity.User;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.exception.UserAlreadyExistsException;
import com.kachinsky.musifindmebackend.mapper.UserDtoMapper;
import com.kachinsky.musifindmebackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;

    @Transactional
    public FlatUserDto getFlatUserById(int id) {
        User user =
                userRepository
                        .findFullUserInfoById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        return userDtoMapper.toFlatUserDto(user);
    }

    @Transactional
    public FlatUserDto updateUserById(int id, UpdateUserDto updateUserDto) {
        User userToUpdate = userRepository
                .findFullUserInfoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        userDtoMapper.partialUpdate(updateUserDto,userToUpdate);

        userRepository.save(userToUpdate);
        return userDtoMapper.toFlatUserDto(userToUpdate);
    }


    public FlatUserDto createUser(CreateUserDto userDto) {
        String userEmail = userDto.getEmail();
        if (userRepository.existsByEmail(userEmail)) {
            throw new UserAlreadyExistsException("User with email " + userEmail + " already exists");
        }

        User userToCreate = userDtoMapper.toEntity(userDto);

        User createdUser = userRepository.save(userToCreate);

        return userDtoMapper.toFlatUserDto(createdUser);

    }
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void deleteArticleById(Long id) {
//        if (id == null || !articleRepository.existsById(id)) {
//            throw new ResourceNotFoundException("Article with id " + id + " not found");
//        }
//
//        // The associated comments are delete with a cascade operation
//        articleRepository.deleteById(id);
//        log.info("Article with id {} deleted", id);
//        // todo check that it's actually deleted with cascade
//    }
}
