package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Integer> {
}