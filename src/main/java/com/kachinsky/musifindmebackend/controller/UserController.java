package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.user.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.user.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.user.FullUserDto;
import com.kachinsky.musifindmebackend.dto.user.UpdateUserDto;
import com.kachinsky.musifindmebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlatUserDto> getAllArtists() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FullUserDto getFullUserById(@PathVariable int id) {
        log.info("Requested user with id {}",id);
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public FullUserDto getFullUserByEmail(@RequestParam String email) {
        log.info("Requested user with email {}", email);
        return userService.getUserByEmail(email);
    }

    // TODO validate nulls
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullUserDto createUser(@RequestBody CreateUserDto userDto) {
        log.info("Requested create of user with email {}",userDto.getEmail());
        return userService.createUser(userDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public FullUserDto updateUserById(@PathVariable int id, @RequestBody UpdateUserDto userDto) {
        log.info("Requested update of user with id {}",id);
        return userService.updateUserById(id, userDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void  deleteUserById(@PathVariable int id) {
        log.info("Requested to delete user with id {}",id);

        userService.deleteUserById(id);
    }

}
