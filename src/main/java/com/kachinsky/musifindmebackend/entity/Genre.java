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
@Table(name = "genres", schema = "public")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Name must be not blank")
    private String name;

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Release> releases = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<Song> songs = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

}