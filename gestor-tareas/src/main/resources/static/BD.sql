DROP DATABASE IF EXISTS Gestor
CREATE DATABASE Gestor;
USE Gestor;
CREATE USER IF NOT EXISTS 'appuser'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON Gestor.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
CREATE TABLE Usuarios(
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         Nombre VARCHAR(50) NOT NULL UNIQUE,
                         Passwd VARCHAR(255) NOT NULL,
                        email VARCHAR(100) NOT NULL UNIQUE,
                        Rol ENUM('ADMIN', 'USUARIO') NOT NULL DEFAULT 'USUARIO',
                        Nombre_completo VARCHAR(100) NOT NULL
);

CREATE TABLE Tareas(
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       Nombre VARCHAR(50) NOT NULL,
                       Descripcion VARCHAR(500) NULL,
                       Estado ENUM("COMPLETADA","EN_PROCESO","PENDIENTE"),
                       id_usuario INT NOT NULL,
                       FOREIGN KEY (id_usuario) REFERENCES Usuarios (ID)
);
INSERT INTO Usuarios (Nombre, Passwd, email, Rol, Nombre_completo) VALUES
                                          ('admin', '$2a$10$ofNI9g6oEfxcBdulMxZ.0OB3kCYe8CBQFwB9ddwOYgswW4b3/fIoa', "admin@admin.com", ADMIN, "admin admin admin" );

INSERT INTO Tareas (Nombre, Descripcion, Estado, id_usuario) VALUES
                                                                ('Comprar comida', 'Ir al supermercado y comprar lo necesario', 'PENDIENTE', 1),
                                                                ('Hacer ejercicio', 'Rutina de 30 minutos en casa', 'COMPLETADA', 1)