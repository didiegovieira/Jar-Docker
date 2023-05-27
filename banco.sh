#!/bin/bash

docker exec ContainerBD mysql -uroot -purubu100 << EOF
CREATE DATABASE IF NOT EXISTS banco1;
USE banco1;

CREATE TABLE log_uso (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_maquina INT NOT NULL,
    id_empresa INT NOT NULL,
    id_usuario INT NOT NULL,
    data_log DATE NULL,
    hora_inicio TIME NULL,
    hora_fim TIME NULL
);

CREATE TABLE registro (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    clock_cpu DOUBLE(5 , 2) NULL,
    temp_cpu DOUBLE(5 , 2) NULL,
    uso_cpu DOUBLE(5 , 2) NULL,
    download_rede DOUBLE(5, 2) NULL,
    upload_rede DOUBLE(5 , 2) NULL,
    uso DOUBLE(7 , 2),
    data_hora DATETIME
);

CREATE TABLE rede(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    ip varchar(20),
    driver varchar(45),
    nome varchar(45)
);

EOF

