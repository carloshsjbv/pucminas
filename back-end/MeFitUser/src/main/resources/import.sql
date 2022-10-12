INSERT INTO user_type (name) VALUES('ADMINISTRADOR');

INSERT INTO user_type (name) VALUES('PERSONAL TRAINER');

INSERT INTO user_type (name) VALUES('ALUNO');

INSERT INTO user (login, name, password, status, user_type_id) VALUES ('root', 'System Admin', 'root', 1, 1);
