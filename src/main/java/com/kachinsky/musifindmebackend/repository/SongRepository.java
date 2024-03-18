package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Song s JOIN s.artists a WHERE s.name = :name AND a.id IN :artistIds")
    boolean existsByNameAndArtists(String name, Set<Integer> artistIds);


}