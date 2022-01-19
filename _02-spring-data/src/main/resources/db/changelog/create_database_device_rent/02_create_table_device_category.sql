-- liquibase formatted sql
-- changeset javastart:1
CREATE TABLE device_category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1024) NOT NULL
);