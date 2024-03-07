package com.kachinsky.musifindmebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city")
    private String city;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "searching_for", length = Integer.MAX_VALUE)
    private String searchingFor;

    @Column(name = "socials_json")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> socialsJson;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Artist> artists = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_genres",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Instrument> instruments = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_releases",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "release_id"))
    private Set<Release> releases = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs = new LinkedHashSet<>();

}