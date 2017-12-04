create database TiendaArteBD;
use TiendaArteBD;

CREATE TABLE MedioPagoBD (
ID_Medio int(11) NOT NULL AUTO_INCREMENT,
nombre varchar(45) DEFAULT NULL,
PRIMARY KEY (ID_Medio)
);

CREATE TABLE CompradoresBD (
ID_Compradores int NOT NULL AUTO_INCREMENT,
nombre varchar(45) DEFAULT NULL,
PRIMARY KEY (ID_Compradores) 
);

CREATE TABLE ArtistasBD  (
ID_Artistas int NOT NULL AUTO_INCREMENT,
nombre varchar(45) DEFAULT NULL,
PRIMARY KEY (ID_Artistas) 
);

CREATE TABLE GaleriaBD (
ID_Galeria int NOT NULL AUTO_INCREMENT,
ID_ArtistaFK int,
nombre varchar(45) DEFAULT NULL,
estilo varchar(45) DEFAULT NULL,
tecnica varchar(45) DEFAULT NULL,
Valor int,
PRIMARY KEY (ID_Galeria), 
FOREIGN KEY (ID_ArtistaFK) REFERENCES ArtistasBD (ID_Artistas)
);

CREATE TABLE CompraBD (
ID_Compra int NOT NULL AUTO_INCREMENT,
ID_CompradorFK int,
ID_GaleriaFK int, 
ID_MedioPagoFK int, 
PRIMARY KEY (ID_Compra), 
FOREIGN KEY (ID_CompradorFK) REFERENCES CompradoresBD (ID_Compradores),
FOREIGN KEY (ID_GaleriaFK) REFERENCES GaleriaBD (ID_Galeria),
FOREIGN KEY (ID_MedioPagoFK) REFERENCES MedioPagoBD (ID_Medio)
);

