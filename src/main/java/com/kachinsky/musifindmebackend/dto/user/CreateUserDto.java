package com.kachinsky.musifindmebackend.dto.user;

import lombok.Value;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.User}
 */
@Value
public class CreateUserDto implements Serializable {
    String name;
    Integer age;
    String city;
    String description;
    String searchingFor;
    Map<String, String> socials;
    String email;
    String password;
    Set<Integer> artists;
    Set<Integer> genres;
    Set<Integer> instruments;
    Set<Integer> releases;
    Set<Integer> songs;
}