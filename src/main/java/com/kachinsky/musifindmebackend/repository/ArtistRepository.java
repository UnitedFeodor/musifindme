package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}