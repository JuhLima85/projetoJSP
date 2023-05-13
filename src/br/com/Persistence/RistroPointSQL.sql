
use registerDb;

-- create database registerDb;
 -- drop database registerDb;

CREATE TABLE HorarioTrabalho (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf varchar(11) NOT null,
    entrada TIME NOT NULL,
    inicio_Intervalo TIME,
    fim_Intervalo TIME,
    saida TIME NOT NULL
);

CREATE TABLE MarcacoesFeitas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf varchar(11)NOT null,
    entrada TIME NOT NULL,
    inicio_Intervalo TIME,
    fim_Intervalo TIME,
    saida TIME NOT NULL
);

CREATE TABLE Atraso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf varchar(11)NOT null,
    entrada TIME NOT NULL,
    inicio_Intervalo TIME,
    fim_Intervalo TIME,
    saida TIME NOT NULL
);

CREATE TABLE HoraExtra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf varchar(11)NOT null,
    entrada TIME NOT NULL,
    inicio_Intervalo TIME,
    fim_Intervalo TIME,
    saida TIME NOT NULL
);
