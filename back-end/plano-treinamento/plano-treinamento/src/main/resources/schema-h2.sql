CREATE SCHEMA treinamentos;

CREATE TABLE `treinamentos`.`plano_treino` (
                                               `id` int PRIMARY KEY AUTO_INCREMENT,
                                               `data_criacao` date,
                                               `user_id` int,
                                               `nome_treino` varchar(255),
                                               `repeticoes` int,
                                               `series` int,
                                               `data_inicio` date,
                                               `data_fim` date,
                                               `active` boolean,
                                               PRIMARY KEY (`id`)
);

CREATE TABLE `treinamentos`.`dia_treinamento` (
                                                  `id` int PRIMARY KEY AUTO_INCREMENT,
                                                  `data_criacao` date,
                                                  `dia_semana` varchar(255),
                                                  `exercicio` int,
                                                  `plano_treino_id` int,
                                                  PRIMARY KEY (`id`)
);

CREATE TABLE `treinamentos`.`exercicio` (
                                            `id` int PRIMARY KEY AUTO_INCREMENT,
                                            `data_criacao` date,
                                            `nome_exercicio` varchar(255),
                                            `grupo_muscular` ENUM ('PEITO',
                                                'OMBRO',
                                                'PERNA',
                                                'PANTURRILHA',
                                                'COSTAS',
                                                'BICEPS',
                                                'TRICEPS'),
                                            `active` boolean,
                                            PRIMARY KEY (`id`)
);

ALTER TABLE `treinamentos`.`dia_treinamento` ADD FOREIGN KEY (`plano_treino_id`) REFERENCES `treinamentos`.`plano_treino` (`id`);

CREATE TABLE `treinamentos`.`dia_treinamento_exercicio` (
                                                            `dia_treinamento_exercicio` int NOT NULL,
                                                            `exercicio_id` int NOT NULL,
                                                            PRIMARY KEY (`dia_treinamento_exercicio`, `exercicio_id`)
);

ALTER TABLE `treinamentos`.`dia_treinamento_exercicio` ADD FOREIGN KEY (`exercicio_id`) REFERENCES `treinamentos`.`exercicio` (`id`);
ALTER TABLE `treinamentos`.`dia_treinamento_exercicio` ADD FOREIGN KEY (`dia_treinamento_exercicio`) REFERENCES `treinamentos`.`dia_treinamento` (`id`);


