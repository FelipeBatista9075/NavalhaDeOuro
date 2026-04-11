ALTER TABLE cliente
    ADD COLUMN email VARCHAR(255);

ALTER TABLE cliente
    ADD CONSTRAINT uk_cliente_email UNIQUE (email);