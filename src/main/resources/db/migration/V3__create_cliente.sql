CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(20) NOT NULL UNIQUE,
    endereco VARCHAR(255),
    usuario_id BIGINT,


    CONSTRAINT fk_cliente_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id)
        ON DELETE SET NULL
);