#!/bin/bash

sudo docker exec -i ContainerBD mysql -uroot -purubu100 << EOF
CREATE DATABASE IF NOT EXISTS banco1;
USE banco1;

CREATE TABLE LogUso (
  id_LogUso INT NOT NULL AUTO_INCREMENT,
  fk_maquina INT NOT NULL,
  fk_empresa INT NOT NULL,
  fk_usuario INT NOT NULL,
  dataLog DATE NULL,
  horaInicio TIME NULL,
  horaFinal TIME NULL,
  PRIMARY KEY (id_LogUso)
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
  PRIMARY KEY (id_registro)
);

EOF

