-- liquibase formatted sql
-- changeset javastart:1
CREATE TABLE device (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2048) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    device_category_id BIGINT NOT NULL,
    CONSTRAINT fk_device_category_id
    FOREIGN KEY (device_category_id) REFERENCES device_category (id)
);







