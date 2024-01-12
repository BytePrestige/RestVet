CREATE TABLE usuario_endereco
(
    id_usuario  INT,
    id_endereco INT,
    PRIMARY KEY (id_usuario, id_endereco),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco)
);