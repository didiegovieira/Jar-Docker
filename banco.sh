sudo docker exec -it ContainerBD bash

mysql -u root -p

use banco1;

CREATE TABLE Empresa (
	id INT PRIMARY KEY auto_increment,
	nome VARCHAR(100) NOT NULL,
	cnpj VARCHAR(14) NOT NULL,
	dono varchar(100)
);

CREATE TABLE Usuario (
	id INT PRIMARY KEY auto_increment,
	PID CHAR(6),
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(100) NOT NULL,
	cargo VARCHAR(20) NOT NULL,
	id_gestor int,
	id_empresa INT NOT NULL,
	FOREIGN KEY (id_gestor) REFERENCES Usuario (id),
	FOREIGN KEY (id_empresa) REFERENCES Empresa (id)
);


INSERT INTO Empresa (nome, cnpj, dono) VALUES ('Minha Empresa', '12345678901234', 'Fulano de Tal');

INSERT INTO Usuario (PID, nome, sobrenome, email, senha, cargo, id_gestor, id_empresa)
VALUES ('ABC123', 'Diego', 'Silva', 'diego@gmail.com', 'urubu100', 'Desenvolvedor', NULL, 1);

CREATE TABLE Maquina (
id INT PRIMARY KEY auto_increment,
sistema_operacional VARCHAR(50) NOT NULL,
modelo varchar(45),
ip varchar(15),
fabricante varchar(45),
id_empresa int,
foreign key (id_empresa) references empresa(id)
);
