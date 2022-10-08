create table TREINAMENTOS.EXERCICIO
(
    ID             INTEGER auto_increment
        primary key,
    DATA_CRIACAO   DATE,
    NOME_EXERCICIO CHARACTER VARYING(255)                                                         not null,
    GRUPO_MUSCULAR ENUM ('PEITO', 'OMBRO', 'PERNA', 'PANTURRILHA', 'COSTAS', 'BICEPS', 'TRICEPS') not null,
    ACTIVE         BOOLEAN
);

