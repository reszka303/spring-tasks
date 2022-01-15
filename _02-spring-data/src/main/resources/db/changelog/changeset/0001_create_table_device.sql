-- liquibase formatted sql
-- changeset id=1, author=javastart
CREATE TABLE device (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2048) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);
