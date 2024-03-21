package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @EntityGraph(attributePaths = {"artists", "genres", "instruments", "releases", "songs"})
    Optional<User> findFullUserInfoById(int id);

    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = {"artists", "genres", "instruments", "releases", "songs"})
    Optional<User> findFullUserInfoByEmail(String email);
}