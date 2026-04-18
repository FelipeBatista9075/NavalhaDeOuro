INSERT INTO usuario (nome, senha, email)
VALUES ('felipe', '123456', 'felipe@email.com');

INSERT INTO barbeiros (
    nome,
    email,
    telefone,
    especialidade,
    nivel,
    usuario_id,
    cpf,
    ativo
)
VALUES (
           'Felipe Batista',
           'felipe@email.com',
           '14999999999',
           'DEGRADE',
           'PLENO',
           1,
           '12345678900',
           TRUE
       );