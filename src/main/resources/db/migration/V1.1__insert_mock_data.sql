-- Insert data into the users table
INSERT INTO users (name, age, city, description, searching_for, socials_json, email, password)
VALUES
    ('John Doe', 25, 'New York', 'Musician and songwriter', 'Collaboration', '{"instagram": "john_doe", "twitter": "john_doe"}', 'john.doe@example.com', 'password123'),
    ('Jane Smith', 30, 'Los Angeles', 'Singer and guitarist', 'Band members', '{"instagram": "jane_smith", "facebook": "jane_smith"}', 'jane.smith@example.com', 'password456'),
    ('Mike Johnson', 35, 'Chicago', 'Bass player', 'Gig opportunities', '{"twitter": "mike_johnson", "linkedin": "mike_johnson"}', 'mike.johnson@example.com', 'password789');

-- Insert data into the instruments table
INSERT INTO instruments (name)
VALUES
    ('Guitar'),
    ('Piano'),
    ('Drums');

-- Insert data into the songs table
INSERT INTO songs (name)
VALUES
    ('Song 1'),
    ('Song 2'),
    ('Song 3');

-- Insert data into the releases table
INSERT INTO releases (name, release_type, release_year, record_label, producer, cover_image_url, description)
VALUES
    ('Album 1', 'Album', 2022, 'Music Label 1', 'Producer 1', 'https://example.com/album1.jpg', 'Debut album'),
    ('EP 1', 'EP', 2023, 'Music Label 2', 'Producer 2', 'https://example.com/ep1.jpg', 'First EP'),
    ('Single 1', 'Single', 2024, 'Music Label 3', 'Producer 3', 'https://example.com/single1.jpg', 'Latest single');

-- Insert data into the genres table
INSERT INTO genres (name)
VALUES
    ('Rock'),
    ('Pop'),
    ('Hip Hop');

-- Insert data into the artists table
INSERT INTO artists (name)
VALUES
    ('Artist 1'),
    ('Artist 2'),
    ('Artist 3');

-- Insert data into the users_instruments table
INSERT INTO users_instruments (user_id, instrument_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the users_releases table
INSERT INTO users_releases (user_id, release_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the users_songs table
INSERT INTO users_songs (user_id, song_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the users_artists table
INSERT INTO users_artists (user_id, artist_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the users_genres table
INSERT INTO users_genres (user_id, genre_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the songs_artists table
INSERT INTO songs_artists (song_id, artist_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the songs_releases table
INSERT INTO songs_releases (song_id, release_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the songs_genres table
INSERT INTO songs_genres (song_id, genre_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the releases_artists table
INSERT INTO releases_artists (release_id, artist_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the releases_genres table
INSERT INTO releases_genres (release_id, genre_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert data into the artists_genres table
INSERT INTO artists_genres (artist_id, genre_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);