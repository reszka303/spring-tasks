-- liquibase formatted sql
-- changeset javastart:1
CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    pesel VARCHAR(11) NOT NULL,
    id_number VARCHAR(10) NOT NULL
);