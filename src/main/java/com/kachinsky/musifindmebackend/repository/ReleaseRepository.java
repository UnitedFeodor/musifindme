package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Integer> {
}