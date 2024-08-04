-- Borrar tabla personajes
DROP TABLE IF EXISTS personajes;

-- Crear tabla personajes
CREATE TABLE IF NOT EXISTS personajes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    edad INT8 NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    CONSTRAINT nacionalidad_valida CHECK (nacionalidad IN (
        'Austria', 'Belgium', 'Bulgaria', 'Croatia', 'Cyprus', 
        'Czech Republic', 'Denmark', 'Estonia', 'Finland', 'France', 
        'Germany', 'Greece', 'Hungary', 'Ireland', 'Italy', 
        'Latvia', 'Lithuania', 'Luxembourg', 'Malta', 
        'Netherlands', 'Poland', 'Portugal', 'Romania', 
        'Slovakia', 'Slovenia', 'Spain', 'Sweden'
    ))
);

-- Eliminar la tabla si existe
DROP TABLE IF EXISTS Profesiones;

-- Crear la tabla con la constraint nombrada
CREATE TABLE Profesiones (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT nombre_profesion_valido CHECK (nombre IN (
        'Periodista', 'Detective', 'Escritor', 'Traficante', 'Mercenario', 'Ladron'
    ))
);

-- Insertar datos en la tabla Profesiones
INSERT INTO Profesiones (nombre) VALUES 
('Periodista'),
('Detective'),
('Escritor'),
('Traficante'),
('Mercenario'),
('Ladron');

--Borrar tabla basePersonajes
DROP TABLE IF EXISTS BasePersonajes;

-- Crear la tabla BasePersonajes
CREATE TABLE IF NOT EXISTS BasePersonajes (
    id SERIAL PRIMARY KEY,
    puntos_vida INT8 DEFAULT 20,
    puntos_destino INT8 DEFAULT 0,
    puntos_experiencia INT8 DEFAULT 0,
    fuerza INT8 NOT NULL,
    destreza INT8 NOT NULL,
    percepcion INT8 NOT NULL,
    personaje_id BIGINT NOT NULL,
    profesion_id BIGINT NOT NULL,
    CONSTRAINT fk_personaje FOREIGN KEY (personaje_id) REFERENCES Personajes(id),
    CONSTRAINT fk_profesion FOREIGN KEY (profesion_id) REFERENCES Profesiones(id)
);