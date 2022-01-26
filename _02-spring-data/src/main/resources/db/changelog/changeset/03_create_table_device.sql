-- liquibase formatted sql
-- changeset javastart:1

CREATE TABLE device (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(2048) NOT NULL,
    name VARCHAR(255)  NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    device_category_id BIGINT,
    CONSTRAINT fk_device_category_id
    FOREIGN KEY (device_category_id) REFERENCES device_category (id)
);
