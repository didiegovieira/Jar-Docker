#!/bin/bash

sudo docker exec -i ContainerBD mysql -uroot -purubu100 << EOF
CREATE DATABASE IF NOT EXISTS banco1;
USE banco1;

CREATE TABLE Empresa (
  id_empresa INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  CNPJ CHAR(14) NOT NULL,
  dono VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_empresa)
);

CREATE TABLE Usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  sobrenome VARCHAR(45) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  cargo VARCHAR(45) NOT NULL,
  fkGestor INT NULL,
  fk_empresa INT NOT NULL,
  PRIMARY KEY (id_usuario),
  CONSTRAINT fk_Usuario_Gestor
    FOREIGN KEY (fkGestor)
    REFERENCES Usuario (id_usuario),
  CONSTRAINT fk_Usuario_Empresa
    FOREIGN KEY (fk_empresa)
    REFERENCES Empresa (id_empresa)
);

CREATE TABLE Maquina (
  id_maquina INT NOT NULL AUTO_INCREMENT,
  sistemaOperacional VARCHAR(45) NOT NULL,
  arquitetura VARCHAR(10) NULL,
  fabricante VARCHAR(45) NULL,
  fk_empresa INT NOT NULL,
  PRIMARY KEY (id_maquina),
  CONSTRAINT fk_Maquina_Empresa
    FOREIGN KEY (fk_empresa)
    REFERENCES Empresa (id_empresa)
);

CREATE TABLE LogUso (
  id_LogUso INT NOT NULL AUTO_INCREMENT,
  fk_maquina INT NOT NULL,
  fk_empresa INT NOT NULL,
  fk_usuario INT NOT NULL,
  dataLog DATE NULL,
  horaInicio TIME NULL,
  horaFinal TIME NULL,
  PRIMARY KEY (id_LogUso),
  CONSTRAINT fk_LogUso_Maquina
    FOREIGN KEY (fk_maquina)
    REFERENCES Maquina (id_maquina),
  CONSTRAINT fk_LogUso_Empresa
    FOREIGN KEY (fk_empresa)
    REFERENCES Empresa (id_empresa),
  CONSTRAINT fk_LogUso_Usuario
    FOREIGN KEY (fk_usuario)
    REFERENCES Usuario (id_usuario)
);

CREATE TABLE Componente (
  id_componente INT NOT NULL AUTO_INCREMENT,
  nomeComponente VARCHAR(100) NOT NULL,
  fabricante VARCHAR(45) NULL,
  tipo VARCHAR(45) NULL,
  ipComponente VARCHAR(20) NULL,
  modelo VARCHAR(45) NULL,
  driver VARCHAR(45) NULL,
  PRIMARY KEY (id_componente)
);

CREATE TABLE ComponenteMaquina (
  id_componenteMaquina INT NOT NULL AUTO_INCREMENT,
  fk_componente INT NOT NULL,
  fk_maquina INT NOT NULL,
  PRIMARY KEY (id_componenteMaquina),
  CONSTRAINT fk_ComponenteMaquina_Componente
    FOREIGN KEY (fk_componente)
    REFERENCES Componente (id_componente),
  CONSTRAINT fk_ComponenteMaquina_Maquina
    FOREIGN KEY (fk_maquina)
    REFERENCES Maquina (id_maquina)
);

CREATE TABLE Registro (
  id_registro INT NOT NULL AUTO_INCREMENT,
  clockCPU BIGINT NULL,
  temperaturaCPU DECIMAL(5,2) NULL,
  usoCPU DECIMAL(3,2) NULL,
  downloadRede BIGINT NULL,
  uploadRede BIGINT NULL,
  usoRAM BIGINT NULL,
  disponivelRam BIGINT NULL,
  totalRam BIGINT NULL,
  usadoDisco DECIMAL(3,1) NULL,
  totalDisco DECIMAL(7,2) NULL,
  disponivelDisco DECIMAL(7,2) NULL,
  fk_componente INT NOT NULL,
  fk_componenteMaquina INT NOT NULL,
  fk_maquina INT NOT NULL,
  PRIMARY KEY (id_registro),
  CONSTRAINT fk_Registro_Componente
    FOREIGN KEY (fk_componente)
    REFERENCES Componente (id_componente),
  CONSTRAINT fk_Registro_ComponenteMaquina
    FOREIGN KEY (fk_componenteMaquina)
    REFERENCES ComponenteMaquina (id_componenteMaquina),
  CONSTRAINT fk_Registro_Maquina
    FOREIGN KEY (fk_maquina)
    REFERENCES Maquina (id_maquina)
);

INSERT INTO Empresa (nome, CNPJ, dono) VALUES ('Minha Empresa', '12345678901234', 'Diego');

INSERT INTO Usuario (nome, sobrenome, email, senha, cargo, fk_empresa) VALUES ('Diego', 'Sobrenome', 'diego@gmail.com', 'diego1234', 'Cargo', 1);

EOF

