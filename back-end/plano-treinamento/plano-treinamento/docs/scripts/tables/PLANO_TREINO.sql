create table TREINAMENTOS.PLANO_TREINO
(
    ID           INTEGER auto_increment
        primary key,
    DATA_CRIACAO DATE,
    USER_ID      INTEGER not null,
    REPETICOES   INTEGER not null,
    SERIES       INTEGER not null,
    DATA_INICIO  DATE    not null,
    DATA_FIM     DATE    not null,
    ACTIVE       BOOLEAN
);

