-- liquibase formatted sql
-- changeset javastart:1

CREATE TABLE device_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1024) NOT NULL
);