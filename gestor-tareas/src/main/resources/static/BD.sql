CREATE DATABASE IF NOT EXISTS Gestor;
USE Gestor;
CREATE USER 'appuser'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON Gestor.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
CREATE TABLE Usuarios(
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         Nombre VARCHAR(50) NOT NULL,
                         Passwd VARCHAR(255) NOT NULL
);

CREATE TABLE Tareas(
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       Nombre VARCHAR(50) NOT NULL,
                       Descripcion VARCHAR(500) NULL,
                       Estado ENUM("COMPLETADA","EN_PROCESO","PENDIENTE"),
                       id_usuario INT NOT NULL,
                       FOREIGN KEY (IdUsuario) REFERENCES Usuarios (ID)
);
INSERT INTO Usuarios (Nombre, Passwd) VALUES
                                          ('admin', '$2a$10$ofNI9g6oEfxcBdulMxZ.0OB3kCYe8CBQFwB9ddwOYgswW4b3/fIoa');

INSERT INTO Tareas (Nombre, Descripcion, Estado, id_usuario) VALUES
                                                                ('Comprar comida', 'Ir al supermercado y comprar lo necesario', 'PENDIENTE', 1),
                                                                ('Hacer ejercicio', 'Rutina de 30 minutos en casa', 'COMPLETADA', 1)