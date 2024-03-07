package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "releases", schema = "public")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "release_type", length = 50)
    private String releaseType;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "record_label")
    private String recordLabel;

    @Column(name = "producer")
    private String producer;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToMany(mappedBy = "releases")
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "releases_genres",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "releases", fetch = FetchType.LAZY)
    private Set<Song> songs = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "releases", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

}