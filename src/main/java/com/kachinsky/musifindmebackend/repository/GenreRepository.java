package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    boolean existsByName(String name);
}