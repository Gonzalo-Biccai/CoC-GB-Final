CREATE DATABASE IF NOT EXISTS db_final
    DEFAULT CHARACTER SET utf8 
    COLLATE utf8_spanish_ci;
	
USE db_final;

CREATE TABLE users (
id INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
nacionalidad VARCHAR(50) NOT NULL);

CREATE TABLE productos (
id INT(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR(50) NOT NULL,
precio INT(10) NOT NULL,
tipo VARCHAR(50) NOT NULL);

INSERT INTO productos (nombre, precio, tipo) VALUES 
("Manzana", 95, "Fruta"),
("Banana", 189, "Fruta"),
("Zanahoria", 189, "Verdura"),
("Lechuga", 259, "Verdura"),
("Pera", 84, "Fruta"),
("Naranja", 109, "Fruta"),
("Sandia", 44, "Fruta"),
("Apio", 349, "Verdura"),
("Cebolla", 127, "Verdura"),
("Maiz", 200, "Verdura"),
("Berenjena", 27, "Verdura"),
("Papa negra", 9, "Verdura"),
("Mango", 350, "Fruta");