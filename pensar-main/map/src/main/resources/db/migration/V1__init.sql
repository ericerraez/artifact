CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100)
    );

CREATE TABLE IF NOT EXISTS location (
    id SERIAL PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6),
    description VARCHAR(100),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS geodata (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    fecha_hora TIMESTAMP,
    atributo_adicional VARCHAR(255),
    user_id INT,
    location_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (location_id) REFERENCES location(id)
    );
