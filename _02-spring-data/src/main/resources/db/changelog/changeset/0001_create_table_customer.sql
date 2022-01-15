-- liquibase formatted sql
-- changeset id=1, author=javastart
CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    pesel VARCHAR(11),
    id_number VARCHAR(10)
);