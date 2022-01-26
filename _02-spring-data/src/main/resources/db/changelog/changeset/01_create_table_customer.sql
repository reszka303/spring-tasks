-- liquibase formatted sql
-- changeset javastart:1

CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45) NOT NULL,
    id_number  VARCHAR(10) NOT NULL,
    pesel      VARCHAR(11) NOT NULL
);
