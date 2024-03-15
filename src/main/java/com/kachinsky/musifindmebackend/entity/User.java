package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name must not be empty")
    private String name;

    @Column(name = "age")
    @Min(value = 12, message = "User age must be at least 12")
    @Max(value = 100, message = "User age is too old")
    private Integer age;

    @Column(name = "city")
    @NotBlank(message = "City must not be empty")
    private String city;

    @Column(name = "description", length = Integer.MAX_VALUE)
    @NotBlank(message = "Description must not be empty")
    private String description;

    @Column(name = "searching_for", length = Integer.MAX_VALUE)
    @NotBlank(message = "'Searching for' criteria must not be empty")
    private String searchingFor;

    @Column(name = "socials_json")
    @JdbcTypeCode(SqlTypes.JSON)
    @NotEmpty(message = "Socials must not be empty")
    private Map<String, String> socialsJson;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password must not be empty")
    private String password;

    @ManyToMany(mappedBy = "users")
    @NotEmpty(message = "Artists must not be empty")
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_genres",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @NotEmpty(message = "Genres must not be empty")
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    @NotEmpty(message = "Instruments must not be empty")
    private Set<Instrument> instruments = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_releases",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "release_id"))
    @NotEmpty(message = "Releases must not be empty")
    private Set<Release> releases = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    @NotEmpty(message = "Songs must not be empty")
    private Set<Song> songs = new LinkedHashSet<>();

}