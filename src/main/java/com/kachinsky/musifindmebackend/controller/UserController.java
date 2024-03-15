package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.UpdateUserDto;
import com.kachinsky.musifindmebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public FlatUserDto getFlatUserById(@PathVariable int id) {
        log.info("Requested user with id {}",id);
        return userService.getFlatUserById(id);
    }

    // TODO validate nulls
    @PostMapping
    public FlatUserDto addUser(@RequestBody CreateUserDto userDto) {
        log.info("Requested create of user with email {}",userDto.getEmail());
        return userService.createUser(userDto);
    }

    @PatchMapping("/{id}")
    public FlatUserDto editUserById(@PathVariable int id, @RequestBody UpdateUserDto userDto) {
        log.info("Requested update of user with id {}",id);
        return userService.updateUserById(id, userDto);
    }

}
