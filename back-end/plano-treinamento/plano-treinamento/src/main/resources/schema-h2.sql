CREATE SCHEMA `treinamentos`;

CREATE TABLE `treinamentos`.`plano_treino` (
                                               `id` int PRIMARY KEY AUTO_INCREMENT,
                                               `data_criacao` date default CURRENT_TIMESTAMP,
                                               `user_id` int NOT NULL,
                                               `repeticoes` int NOT NULL,
                                               `series` int NOT NULL,
                                               `data_inicio` date NOT NULL,
                                               `data_fim` date NOT NULL,
                                               `active` boolean default true
);

CREATE TABLE `treinamentos`.`dia_treinamento` (
                                                  `id` int PRIMARY KEY AUTO_INCREMENT,
                                                  `data_criacao` date default CURRENT_TIMESTAMP,
                                                  `dia_semana` varchar(255) NOT NULL,
                                                  `plano_treino_id` int
);

CREATE TABLE `treinamentos`.`exercicio` (
                                            `id` int PRIMARY KEY AUTO_INCREMENT,
                                            `data_criacao` date default CURRENT_TIMESTAMP,
                                            `nome_exercicio` varchar(255) NOT NULL,
                                            `grupo_muscular` ENUM ('PEITO', 'OMBRO', 'PERNA', 'PANTURRILHA', 'COSTAS', 'BICEPS', 'TRICEPS') NOT NULL,
                                            `active` boolean  default true
);

CREATE TABLE `treinamentos`.`dia_treinamento_x_exercicio` (
                                                              `exercicio_id` int NOT NULL,
                                                              `dia_treinamento_id` int NOT NULL,
                                                              PRIMARY KEY (`dia_treinamento_id`, `exercicio_id`)
);

ALTER TABLE `treinamentos`.`dia_treinamento` ADD FOREIGN KEY (`plano_treino_id`) REFERENCES `treinamentos`.`plano_treino` (`id`);

ALTER TABLE `treinamentos`.`dia_treinamento_x_exercicio` ADD FOREIGN KEY (`dia_treinamento_id`) REFERENCES `treinamentos`.`dia_treinamento` (`id`);

ALTER TABLE `treinamentos`.`dia_treinamento_x_exercicio` ADD FOREIGN KEY (`exercicio_id`) REFERENCES `treinamentos`.`exercicio` (`id`);
