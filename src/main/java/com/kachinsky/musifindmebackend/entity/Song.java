package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "songs", schema = "public")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name must be not blank")
    private String name;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    @NotEmpty(message = "Artists must be not blank")
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "songs_genres",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @NotEmpty(message = "Genres must be not blank")
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "songs_releases",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "release_id"))
//    @NotEmpty(message = "Releases must be not blank")
    private Set<Release> releases = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

}