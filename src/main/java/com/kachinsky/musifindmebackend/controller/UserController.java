package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.FlatUserDto;
import com.kachinsky.musifindmebackend.dto.FullUserDto;
import com.kachinsky.musifindmebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public FlatUserDto getFlatUserById(@PathVariable int id) {
        return userService.getFullUserById(id);
    }
}
