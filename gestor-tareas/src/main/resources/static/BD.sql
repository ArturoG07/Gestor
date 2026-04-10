CREATE USER 'appuser'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON Gestor.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
CREATE DATABASE IF NOT EXISTS Gestor;
USE Gestor;
CREATE TABLE Usuarios(
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         Nombre VARCHAR(50) NOT NULL,
                         Passwd VARCHAR(50) NOT NULL
);

CREATE TABLE Tareas(
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       Nombre VARCHAR(50) NOT NULL,
                       Descripcion VARCHAR(500) NULL,
                       Estado ENUM("COMPLETADA","EN_PROCESO","PENDIENTE"),
                       IdUsuario INT NOT NULL,
                       FOREIGN KEY (IdUsuario) REFERENCES Usuarios (ID)
);
INSERT INTO Usuarios (Nombre, Passwd) VALUES
                                          ('admin', 'admin'),
                                          ('Juan', '1234'),
                                          ('Maria', 'abcd'),
                                          ('Carlos', 'pass123'),
                                          ('Lucia', 'qwerty'),
                                          ('Pedro', 'secreto');

INSERT INTO Tareas (Nombre, Descripcion, Estado, IdUsuario) VALUES
                                                                ('Comprar comida', 'Ir al supermercado y comprar lo necesario', 'PENDIENTE', 1),
                                                                ('Estudiar SQL', 'Repasar joins y subconsultas', 'EN_PROCESO', 2),
                                                                ('Hacer ejercicio', 'Rutina de 30 minutos en casa', 'COMPLETADA', 1),
                                                                ('Leer libro', 'Terminar el capítulo 5', 'PENDIENTE', 3),
                                                                ('Preparar presentación', 'Slides para la reunión del lunes', 'EN_PROCESO', 4),
                                                                ('Limpiar casa', 'Ordenar habitación y cocina', 'COMPLETADA', 5),
                                                                ('Enviar emails', 'Responder correos pendientes', 'PENDIENTE', 2);