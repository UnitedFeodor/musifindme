package com.kachinsky.musifindmebackend.controller;

import com.kachinsky.musifindmebackend.dto.auth.LoginRequestDto;
import com.kachinsky.musifindmebackend.dto.user.CreateUserDto;
import com.kachinsky.musifindmebackend.dto.user.FullUserDto;
import com.kachinsky.musifindmebackend.security.jwt.JwtUtils;
import com.kachinsky.musifindmebackend.security.service.UserDetailsImpl;
import com.kachinsky.musifindmebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseCookie;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;


//    private final RoleRepository roleRepository;


    private final JwtUtils jwtUtils;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDto loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .toList();

        FullUserDto userById = userService.getUserById(Math.toIntExact(userDetails.getId()));

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(userById);
    }

    @PostMapping("/signup")
    public FullUserDto createUser(@RequestBody CreateUserDto userDto) {
        log.info("Requested signup of user with email {}",userDto.getEmail());
        return userService.createUser(userDto);
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.noContent().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }
}
