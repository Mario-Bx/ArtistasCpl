CREATE TABLE MedioPagoBD (
ID_Medio serial,
nombre VARCHAR,
PRIMARY KEY (ID_Medio)
);

CREATE TABLE CompradoresBD (
ID_Compradores serial,
nombre VARCHAR,
PRIMARY KEY (ID_Compradores) 
);

CREATE TABLE ArtistasBD  (
ID_Artistas serial,
nombre VARCHAR,
PRIMARY KEY (ID_Artistas) 
);

CREATE TABLE GaleriaBD (
ID_Galeria serial,
ID_ArtistaFK int,
nombre VARCHAR,
estilo VARCHAR,
tecnica VARCHAR,
Valor int,
PRIMARY KEY (ID_Galeria), 
FOREIGN KEY (ID_ArtistaFK) REFERENCES ArtistasBD (ID_Artistas)
);

CREATE TABLE CompraBD (
ID_Compra serial,
ID_CompradorFK int,
ID_GaleriaFK int, 
ID_MedioPagoFK int, 
PRIMARY KEY (ID_Compra), 
FOREIGN KEY (ID_CompradorFK) REFERENCES CompradoresBD (ID_Compradores),
FOREIGN KEY (ID_GaleriaFK) REFERENCES GaleriaBD (ID_Galeria),
FOREIGN KEY (ID_MedioPagoFK) REFERENCES MedioPagoBD (ID_Medio)
);

