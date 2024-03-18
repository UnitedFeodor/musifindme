package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

    boolean existsByName(String name);

}