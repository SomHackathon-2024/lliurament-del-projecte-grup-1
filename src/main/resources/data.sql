--Tables
CREATE TABLE categories (
                            id VARCHAR(50) PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
                       id VARCHAR(50) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       surname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       gender VARCHAR(50),
                       username VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE activities (
                            id VARCHAR(50) PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            dateTime DATETIME NOT NULL,
                            location VARCHAR(255) NOT NULL,
                            organizer VARCHAR(50),
                            FOREIGN KEY (organizer) REFERENCES users(id)
);

CREATE TABLE activity_participants (
                                       activity_id VARCHAR(50),
                                       user_id VARCHAR(50),
                                       PRIMARY KEY (activity_id, user_id),
                                       FOREIGN KEY (activity_id) REFERENCES activities(id),
                                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE topics (
                        id VARCHAR(50) PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description VARCHAR(255) NOT NULL
);

CREATE TABLE messages (
                          id VARCHAR(50) PRIMARY KEY,
                          topicId VARCHAR(50),
                          content TEXT NOT NULL,
                          sender VARCHAR(50),
                          FOREIGN KEY (topicId) REFERENCES topics(id),
                          FOREIGN KEY (sender) REFERENCES users(id)
);


-- Inserción de Categorías
INSERT INTO categories (id,name) VALUES
                                               ('Ru0', 'Rutes'),
                                               ('Act0', 'Activitats'),
                                               ('Ser0', 'Serveis'),
                                               ('Com0', 'Comunitat');

-- Inserción de Usuarios
INSERT INTO users (id, name, surname, email, gender, username) VALUES
                                                                   ('44e128a5ac7a4c9abe4c224b6bf81b30', 'Ana', 'Martinez', 'ana.martinez@example.com', 'Female', 'anamartinez'),
                                                                   ('44e128a5ac7a4c9abe4c224b6bf81b31', 'Luis', 'García', 'luis.garcia@example.com', 'Male', 'luisgarcia'),
                                                                   ('44e128a5ac7a4c9abe4c224b6bf81b32', 'Sofía', 'López', 'sofia.lopez@example.com', 'Female', 'sofialopez'),
                                                                   ('44e128a5ac7a4c9abe4c224b6bf81b33', 'Carlos', 'Fernández', 'carlos.fernandez@example.com', 'Male', 'carlosfernandez');


-- Inserción de Actividades
INSERT INTO activities (id, name, description, dateTime, location, organizer) VALUES
    ('Act1', 'Caminata Ecológica', 'Una caminata en el parque nacional para promover la conciencia ambiental.', '2023-09-15 09:00:00', 'Parque Nacional', '44e128a5ac7a4c9abe4c224b6bf81b30');

-- Añadir participantes a la actividad
INSERT INTO activity_participants (activity_id, user_id) VALUES
                                                          ('Act1', '44e128a5ac7a4c9abe4c224b6bf81b30'),
                                                          ('Act1', '44e128a5ac7a4c9abe4c224b6bf81b31'),
                                                          ('Act1', '44e128a5ac7a4c9abe4c224b6bf81b32');

-- Insertar un Topic
INSERT INTO topics (id, title, description) VALUES
    ('1', 'Conservación Ambiental', 'Discusiones sobre prácticas de conservación ambiental.');
    ('2', 'Ayudar con el agua', 'Discusiones sobre prácticas de preservar el agua.');

-- Insertar Messages relacionados con el Topic
INSERT INTO messages (id, topicId, content, sender) VALUES
                                                ('m0', '1', '¿Cuáles son las mejores prácticas para reducir el desperdicio?'),
                                                ('m1', '1', 'Compartiendo un artículo interesante sobre reforestación.'),
                                                ('m2', '2', '¿Cómo podemos contribuir individualmente a la conservación del agua?');






