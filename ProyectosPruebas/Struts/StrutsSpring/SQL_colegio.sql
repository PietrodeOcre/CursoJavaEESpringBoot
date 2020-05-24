CREATE DATABASE  IF NOT EXISTS `text1`;
USE `test1`;

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `id_alumno` int(11) NOT NULL AUTO_INCREMENT,
  `id_domicilio` int(11) DEFAULT NULL,
  `id_contacto` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`),
  KEY `fk_domicilio_idx` (`id_domicilio`),
  KEY `fk_contacto_idx` (`id_contacto`),
  CONSTRAINT `fk_contacto` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id_contacto`),
  CONSTRAINT `fk_domicilio` FOREIGN KEY (`id_domicilio`) REFERENCES `domicilio` (`id_domicilio`)
);

LOCK TABLES `alumno` WRITE;
INSERT INTO `alumno` VALUES (1,1,1,'Juan','Perez'),(2,2,2,'Karla','Gomez');
UNLOCK TABLES;

DROP TABLE IF EXISTS `asignacion`;

CREATE TABLE `asignacion` (
  `id_asignacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` int(11) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `turno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_asignacion`),
  KEY `fk_alumno_idx` (`id_alumno`),
  KEY `fk_curso_idx` (`id_curso`),
  CONSTRAINT `fk_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `fk_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`)
);

LOCK TABLES `asignacion` WRITE;
INSERT INTO `asignacion` VALUES (1,1,1,'Matutino'),(2,2,2,'Vespertino'),(3,1,2,'Vespertino');
UNLOCK TABLES;

DROP TABLE IF EXISTS `contacto`;

CREATE TABLE `contacto` (
  `id_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_contacto`)
);

LOCK TABLES `contacto` WRITE;
INSERT INTO `contacto` VALUES (1,'55443322','jperez@mail.com'),(2,'33221188','kgomez@mail.com');
UNLOCK TABLES;

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id_curso`)
);

LOCK TABLES `curso` WRITE;
INSERT INTO `curso` VALUES (1,'Fundamentos de Java',200),(2,'Java con JDBC',300);
UNLOCK TABLES;

DROP TABLE IF EXISTS `domicilio`;

CREATE TABLE `domicilio` (
  `id_domicilio` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) DEFAULT NULL,
  `no_calle` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_domicilio`)
);


LOCK TABLES `domicilio` WRITE;
INSERT INTO `domicilio` VALUES (1,'Saturno','15','Mexico'),(2,'Candelaria','35','Colombia');
UNLOCK TABLES;

-- Dump completed on 2020-01-21 19:14:23