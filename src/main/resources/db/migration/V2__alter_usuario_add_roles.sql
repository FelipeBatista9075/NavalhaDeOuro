CREATE TABLE usuario_roles (
    usuario_id INT NOT NULL,
    role VARCHAR(50) NOT NULL,

    CONSTRAINT fk_usuario
    FOREIGN KEY(usuario_id)
    REFERENCES usuario(id)
    ON DELETE CASCADE
);