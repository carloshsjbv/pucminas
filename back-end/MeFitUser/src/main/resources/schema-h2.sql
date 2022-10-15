CREATE TABLE "USER_TYPE"
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_user_type PRIMARY KEY (id)
);

CREATE TABLE "USER"
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    login     VARCHAR(255)          NOT NULL,
    name      VARCHAR(255)          NOT NULL,
    password  VARCHAR(255)          NOT NULL,
    status    INT                   NOT NULL,
    user_type_id BIGINT          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "USER"
    ADD CONSTRAINT FK_USER_ON_USERTYPE FOREIGN KEY (user_type_id) REFERENCES user_type (id);
