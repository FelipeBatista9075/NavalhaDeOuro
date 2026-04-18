CREATE TABLE barbeiros (
                           id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           telefone VARCHAR(50) NOT NULL,
                           especialidade VARCHAR(50) NOT NULL,
                           nivel VARCHAR(50) NOT NULL,
                           usuario_id BIGINT UNIQUE,
                           cpf VARCHAR(20) NOT NULL UNIQUE,
                           ativo BOOLEAN NOT NULL DEFAULT TRUE,

                           CONSTRAINT fk_barbeiro_usuario
                               FOREIGN KEY (usuario_id)
                                   REFERENCES usuario(id)
);