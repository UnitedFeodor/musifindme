package com.kachinsky.musifindmebackend.service;

import com.kachinsky.musifindmebackend.dto.user.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.user.FullUserDto;
import com.kachinsky.musifindmebackend.dto.user.UpdateUserDto;
import com.kachinsky.musifindmebackend.entity.User;
import com.kachinsky.musifindmebackend.exception.ResourceAlreadyExistsException;
import com.kachinsky.musifindmebackend.exception.ResourceNotFoundException;
import com.kachinsky.musifindmebackend.mapper.UserDtoMapper;
import com.kachinsky.musifindmebackend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDtoMapper userDtoMapper;
    private final UserRepository userRepository;

    @Transactional
    public List<FlatUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userDtoMapper.toDto(users);
    }
    
    @Transactional
    public FullUserDto getUserById(int id) {
        User user =
                userRepository
                        .findFullUserInfoById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        return userDtoMapper.toFullDto(user);
    }

    @Transactional
    public FullUserDto updateUserById(int id, UpdateUserDto updateUserDto) {
        User userToUpdate = userRepository
                .findFullUserInfoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));

        userDtoMapper.partialUpdate(updateUserDto,userToUpdate);

        userRepository.save(userToUpdate);
        return userDtoMapper.toFullDto(userToUpdate);
    }

    // TODO fix bug with null joins
    @Transactional
    public FullUserDto createUser(CreateUserDto userDto) {
        String userEmail = userDto.getEmail();
        if (userRepository.existsByEmail(userEmail)) {
            throw new ResourceAlreadyExistsException("User with email " + userEmail + " already exists");
        }

        User userToCreate = userDtoMapper.toEntity(userDto);

        User createdUser = userRepository.save(userToCreate);

        return userDtoMapper.toFullDto(createdUser);

//        User user =
//                userRepository
//                        .findFullUserInfoById(createdUser.getId())
//                        .orElseThrow(() -> new ResourceNotFoundException("User with id " + createdUser.getId() + " not found"));

//        return userDtoMapper.toFlatUserDto(user);

    }

    @Transactional
    public void deleteUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }

        // The associated instruments
        userRepository.deleteById(id);
        log.info("User with id {} deleted", id);

    }

    @Transactional
    public FullUserDto getUserByEmail(String email) {
        User user =
                userRepository
                        .findFullUserInfoByEmail(email)
                        .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));

        return userDtoMapper.toFullDto(user);

    }
}
