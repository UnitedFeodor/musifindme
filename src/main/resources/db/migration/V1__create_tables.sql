CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    age           INTEGER,
    city          VARCHAR(255),
    description   TEXT,
    searching_for TEXT,
    socials_json  JSONB,
    email         VARCHAR(255) UNIQUE NOT NULL,
    password      VARCHAR(255) NOT NULL
);


CREATE TABLE instruments
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE songs
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE releases
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    release_type    VARCHAR(50),
    release_year    INTEGER,
    record_label    VARCHAR(255),
    producer        VARCHAR(255),
    cover_image_url VARCHAR(255),
    description     TEXT
);

CREATE TABLE genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE artists
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users_instruments
(
    user_id       INTEGER REFERENCES users (id),
    instrument_id INTEGER REFERENCES instruments (id),
    PRIMARY KEY (user_id, instrument_id)
);

CREATE TABLE users_releases
(
    user_id    INTEGER REFERENCES users (id),
    release_id INTEGER REFERENCES releases (id),
    PRIMARY KEY (user_id, release_id)
);

CREATE TABLE users_songs
(
    user_id INTEGER REFERENCES users (id),
    song_id INTEGER REFERENCES songs (id),
    PRIMARY KEY (user_id, song_id)
);

CREATE TABLE users_artists
(
    user_id   INTEGER REFERENCES users (id),
    artist_id INTEGER REFERENCES artists (id),
    PRIMARY KEY (user_id, artist_id)
);

CREATE TABLE users_genres
(
    user_id  INTEGER REFERENCES users (id),
    genre_id INTEGER REFERENCES genres (id),
    PRIMARY KEY (user_id, genre_id)
);

CREATE TABLE songs_artists
(
    song_id   INTEGER REFERENCES songs (id),
    artist_id INTEGER REFERENCES artists (id),
    PRIMARY KEY (song_id, artist_id)
);

CREATE TABLE songs_releases
(
    song_id    INTEGER REFERENCES songs (id),
    release_id INTEGER REFERENCES releases (id),
    PRIMARY KEY (song_id, release_id)
);

CREATE TABLE songs_genres
(
    song_id  INTEGER REFERENCES songs (id),
    genre_id INTEGER REFERENCES genres (id),
    PRIMARY KEY (song_id, genre_id)
);

CREATE TABLE releases_artists
(
    release_id INTEGER REFERENCES releases (id),
    artist_id  INTEGER REFERENCES artists (id),
    PRIMARY KEY (release_id, artist_id)
);

CREATE TABLE releases_genres
(
    release_id INTEGER REFERENCES releases (id),
    genre_id   INTEGER REFERENCES genres (id),
    PRIMARY KEY (release_id, genre_id)
);

CREATE TABLE artists_genres
(
    artist_id INTEGER REFERENCES artists (id),
    genre_id  INTEGER REFERENCES genres (id),
    PRIMARY KEY (artist_id, genre_id)
);
