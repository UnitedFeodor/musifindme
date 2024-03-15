package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotBlank(message = "Name must be not blank")
    private String name;

    @Column(name = "release_type", length = 50)
    @NotBlank(message = "Release type must be not blank")
    private String releaseType;

    @Column(name = "release_year")
    @Min(value = 0,message = "Release must no be negative")
    private Integer releaseYear;

    @Column(name = "record_label")
    @NotBlank(message = "Record label must be not blank")
    private String recordLabel;

    @Column(name = "producer")
    @NotBlank(message = "Producer must be not blank")
    private String producer;

    @Column(name = "cover_image_url")
    @NotBlank(message = "Cover image url must be not blank")
    private String coverImageUrl;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToMany(mappedBy = "releases")
    @NotEmpty(message = "Artists must be not empty")
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "releases_genres",
            joinColumns = @JoinColumn(name = "release_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @NotEmpty(message = "Genres must be not empty")
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "releases", fetch = FetchType.LAZY)
    private Set<Song> songs = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "releases", fetch = FetchType.LAZY)
    private Set<User> users = new LinkedHashSet<>();

}