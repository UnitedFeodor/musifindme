package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Release r JOIN r.artists a WHERE r.name = :name AND a.id IN :artistIds")
    boolean existsByNameAndArtists(String name, Set<Integer> artistIds);

}