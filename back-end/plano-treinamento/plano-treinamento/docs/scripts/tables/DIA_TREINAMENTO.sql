create table TREINAMENTOS.DIA_TREINAMENTO
(
    ID              INTEGER auto_increment
        primary key,
    DATA_CRIACAO    DATE,
    DIA_SEMANA      CHARACTER VARYING(255) not null,
    PLANO_TREINO_ID INTEGER
        references TREINAMENTOS.PLANO_TREINO
);

