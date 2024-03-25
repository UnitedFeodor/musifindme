package com.kachinsky.musifindmebackend.repository;

import com.kachinsky.musifindmebackend.entity.Role;
import com.kachinsky.musifindmebackend.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName name);
}