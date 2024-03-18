package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instruments", schema = "public")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name must be not blank")
    private String name;

    @ManyToMany(mappedBy = "instruments", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

}