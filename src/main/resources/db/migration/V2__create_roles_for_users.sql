-- Step 1: Create the "roles" table
CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(20) NOT NULL UNIQUE
);

-- Step 2: Populate the "roles" table with the ROLE_USER role
INSERT INTO roles (name) VALUES ('ROLE_USER');

-- Step 3: Create the join table "users_roles" to establish a many-to-many relationship
CREATE TABLE users_roles (
                             user_id INTEGER REFERENCES users(id),
                             role_id INTEGER REFERENCES roles(id),
                             PRIMARY KEY (user_id, role_id)
);

-- Step 4: Assign the ROLE_USER role to every existing user
INSERT INTO users_roles (user_id, role_id)
SELECT id, (SELECT id FROM roles WHERE name = 'ROLE_USER')
FROM users;
