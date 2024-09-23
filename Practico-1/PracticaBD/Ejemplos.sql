CREATE TABLE Persona (
    id_persona INT PRIMARY KEY,
    name VARCHAR(120),
    esSocio boolean
);

CREATE TABLE Socio (
    id_socio INT PRIMARY KEY,
    id_persona int,
    membresia boolean,
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

SELECT * FROM Persona;
SELECT * FROM Socio;

SELECT * FROM Socio RIGHT JOIN Persona p on p.id_persona = Socio.id_persona