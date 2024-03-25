package com.kachinsky.musifindmebackend.dto.user;

import com.kachinsky.musifindmebackend.entity.RoleName;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.kachinsky.musifindmebackend.entity.Role}
 */
@Value
public class RoleDto implements Serializable {
    Integer id;
    RoleName name;
}