#!/bin/bash

# Cria o banco de dados e as tabelas
docker exec -i ContainerBD mysql -uroot -psuasenha << EOF
CREATE DATABASE IF NOT EXISTS banco1;
USE banco1;

-- Criação da tabela Empresa
CREATE TABLE Empresa (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  dono VARCHAR(100)
);

-- Criação da tabela Maquina
CREATE TABLE Maquina (
  id INT PRIMARY KEY AUTO_INCREMENT,
  sistema_operacional VARCHAR(50) NOT NULL,
  modelo VARCHAR(45),
  fabricante VARCHAR(45),
  id_empresa INT,
  FOREIGN KEY (id_empresa) REFERENCES Empresa(id)
);

-- Criação da tabela Usuario
CREATE TABLE Usuario (
  id INT PRIMARY KEY AUTO_INCREMENT,
  PID CHAR(6),
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  cargo VARCHAR(20) NOT NULL,
  id_gestor INT,
  id_empresa INT NOT NULL,
  FOREIGN KEY (id_gestor) REFERENCES Usuario(id),
  FOREIGN KEY (id_empresa) REFERENCES Empresa(id)
);

-- Inserção de dados na tabela Empresa
INSERT INTO Empresa (nome, cnpj, dono) VALUES ('Empresa A', '12345678901234', 'João da Silva');
INSERT INTO Empresa (nome, cnpj, dono) VALUES ('Empresa B', '98765432109876', 'Maria Souza');

-- Inserção de dados na tabela Maquina
INSERT INTO Maquina (sistema_operacional, modelo, fabricante, id_empresa) VALUES ('Windows 10', 'Dell XPS 13', 'Dell', 1);
INSERT INTO Maquina (sistema_operacional, modelo, fabricante, id_empresa) VALUES ('Ubuntu 20.04', 'Lenovo ThinkPad', 'Lenovo', 1);
INSERT INTO Maquina (sistema_operacional, modelo, fabricante, id_empresa) VALUES ('Windows 10', 'Dell Inspiron', 'Dell', 2);

-- Inserção de dados na tabela Usuario
INSERT INTO Usuario (PID, nome, sobrenome, email, senha, cargo, id_gestor, id_empresa) VALUES ('123456', 'Pedro', 'Silva', 'pedro@empresa1.com', 'senha123', 'Analista', NULL, 1);
INSERT INTO Usuario (PID, nome, sobrenome, email, senha, cargo, id_gestor, id_empresa) VALUES ('789012', 'Ana', 'Souza', 'ana@empresa1.com', 'senha456', 'Coordenador', 1, 1);
INSERT INTO Usuario (PID, nome, sobrenome, email, senha, cargo, id_gestor, id_empresa) VALUES ('345678', 'Lucas', 'Ferreira', 'lucas@empresa2.com', 'senha789', 'Analista', NULL, 2);
EOF

