CREATE TABLE atendente
(
    id_atendente   INT PRIMARY KEY AUTO_INCREMENT,
    nome           VARCHAR(255),
    idade          INT,
    cpf_cnpj       VARCHAR(14) UNIQUE,
    email          VARCHAR(100),
    senha          VARCHAR(50)
);

CREATE TABLE veterinario
(
    id_veterinario INT PRIMARY KEY AUTO_INCREMENT,
    crmv           VARCHAR(20),
    especialidade  VARCHAR(100),
    nome           VARCHAR(255),
    idade          INT,
    cpf_cnpj       VARCHAR(14) UNIQUE,
    email          VARCHAR(100),
    senha          VARCHAR(50)
);

CREATE TABLE tosador
(
    id_tosador     INT PRIMARY KEY AUTO_INCREMENT,
    nome           VARCHAR(255),
    idade          INT,
    cpf_cnpj       VARCHAR(14) UNIQUE,
    email          VARCHAR(100),
    senha          VARCHAR(50)
);

CREATE TABLE usuario
(
    id_usuario       INT PRIMARY KEY AUTO_INCREMENT,
    nome_usuario     VARCHAR(255),
    telefone_usuario VARCHAR(20),
    email            VARCHAR(100),
    senha            VARCHAR(50)
);

CREATE TABLE endereco
(
    id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    cep         VARCHAR(10),
    rua         VARCHAR(255),
    numero      INT,
    bairro      VARCHAR(100),
    cidade      VARCHAR(100),
    estado      VARCHAR(50),
    pais        VARCHAR(50),
    complemento VARCHAR(255)
);

CREATE TABLE animal
(
    id_animal            INT PRIMARY KEY AUTO_INCREMENT,
    nome_animal          VARCHAR(255),
    raca                 VARCHAR(100),
    alergia              VARCHAR(255),
    data_nascimento      DATE,
    status_do_tratamento VARCHAR(50)
);

CREATE TABLE doenca
(
    id_doenca        INT PRIMARY KEY AUTO_INCREMENT,
    nivel_perigo     VARCHAR(50),
    descricao_doenca VARCHAR(255)
);

CREATE TABLE animal_doenca
(
    id_animal INT,
    id_doenca INT,
    PRIMARY KEY (id_animal, id_doenca),
    FOREIGN KEY (id_animal) REFERENCES animal (id_animal),
    FOREIGN KEY (id_doenca) REFERENCES doenca (id_doenca)
);

CREATE TABLE vacina
(
    id_vacina         INT PRIMARY KEY AUTO_INCREMENT,
    nome_da_vacina    VARCHAR(255),
    data_da_aplicacao DATE
);

CREATE TABLE animal_vacina
(
    id_animal INT,
    id_vacina INT,
    PRIMARY KEY (id_animal, id_vacina),
    FOREIGN KEY (id_animal) REFERENCES animal (id_animal),
    FOREIGN KEY (id_vacina) REFERENCES vacina (id_vacina)
);

CREATE TABLE peso
(
    id_peso INT PRIMARY KEY AUTO_INCREMENT,
    peso    DECIMAL(5, 2),
    data    DATE
);

CREATE TABLE animal_peso
(
    id_animal INT,
    id_peso   INT,
    PRIMARY KEY (id_animal, id_peso),
    FOREIGN KEY (id_animal) REFERENCES animal (id_animal),
    FOREIGN KEY (id_peso) REFERENCES peso (id_peso)
);

CREATE TABLE usuario_animal
(
    id_usuario INT,
    id_animal  INT,
    PRIMARY KEY (id_usuario, id_animal),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_animal) REFERENCES animal (id_animal)
);
