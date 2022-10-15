CREATE SCHEMA `WORKOUTS`;

CREATE TABLE `WORKOUTS`.`WORKOUT_PLAN` (
                                              `ID` int PRIMARY KEY AUTO_INCREMENT,
                                              `CREATE_DATE` date default CURRENT_TIMESTAMP,
                                              `USER_ID` int NOT NULL,
                                              `PERSONAL_ID` int NOT NULL,
                                              `REPS` int NOT NULL,
                                              `SERIES` int NOT NULL,
                                              `START_DATE` date NOT NULL,
                                              `END_DATE` date NOT NULL,
                                              `ACTIVE` boolean default true
);

CREATE TABLE `WORKOUTS`.`WORKOUT_DAY` (
                                          `ID` int PRIMARY KEY AUTO_INCREMENT,
                                          `CREATE_DATE` date default CURRENT_TIMESTAMP,
                                          `WEEK_DAY` varchar(255) NOT NULL,
                                          `WORKOUT_PLAN_ID` int
);

CREATE TABLE `WORKOUTS`.`EXERCISE` (
                                       `ID` int PRIMARY KEY AUTO_INCREMENT,
                                       `CREATE_DATE` date default CURRENT_TIMESTAMP,
                                       `NAME` varchar(255) NOT NULL,
                                       `MUSCULAR_GROUP` ENUM ('PEITO', 'OMBRO', 'PERNA', 'PANTURRILHA', 'COSTAS', 'BICEPS', 'TRICEPS') NOT NULL,
                                       `ACTIVE` boolean  default true
);

CREATE TABLE `WORKOUTS`.`WORKOUT_DAY_X_EXERCISE` (
                                                     `EXERCISE_ID` int NOT NULL,
                                                     `WORKOUT_DAY_ID` int NOT NULL,
                                                     PRIMARY KEY (`WORKOUT_DAY_ID`, `EXERCISE_ID`)
);

ALTER TABLE `WORKOUTS`.`WORKOUT_DAY` ADD FOREIGN KEY (`WORKOUT_PLAN_ID`) REFERENCES `WORKOUTS`.`WORKOUT_PLAN` (`ID`);

ALTER TABLE `WORKOUTS`.`WORKOUT_DAY_X_EXERCISE` ADD FOREIGN KEY (`WORKOUT_DAY_ID`) REFERENCES `WORKOUTS`.`WORKOUT_DAY` (`ID`);

ALTER TABLE `WORKOUTS`.`WORKOUT_DAY_X_EXERCISE` ADD FOREIGN KEY (`EXERCISE_ID`) REFERENCES `WORKOUTS`.`EXERCISE` (`ID`);
