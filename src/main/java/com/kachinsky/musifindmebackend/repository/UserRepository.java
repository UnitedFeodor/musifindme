package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}