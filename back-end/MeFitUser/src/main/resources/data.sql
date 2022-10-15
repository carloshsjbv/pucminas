INSERT INTO "USER_TYPE" (id, name) VALUES (1, 'ADMINISTRADOR');
INSERT INTO "USER_TYPE" (id, name) VALUES (2, 'PERSONAL TRAINER');
INSERT INTO "USER_TYPE" (id, name) VALUES (3, 'ALUNO');

INSERT INTO "USER" (login, name, password, status, user_type_id) VALUES ('root', 'System Admin', 'root', 1, 1);
INSERT INTO "USER" (login, name, password, status, user_type_id) VALUES ('carloshsjbv@gmail.com', 'Carlos Francisco', 'senh@', 1, 2);
INSERT INTO "USER" (login, name, password, status, user_type_id) VALUES ('andregodan@gmail.com', 'Andre Machado', 'senh@', 1, 2);
INSERT INTO "USER" (login, name, password, status, user_type_id) VALUES ('andregodan@gmail.com', 'Caio Francisco', 'senh@', 0, 2);
INSERT INTO "USER" (login, name, password, status, user_type_id) VALUES ('carloshsjbv@gmail.com', 'Ana Garcia', 'senh@', 1, 3);
