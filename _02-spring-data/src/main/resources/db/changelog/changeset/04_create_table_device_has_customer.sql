-- liquibase formatted sql
-- changeset id=1, author=javastart
CREATE TABLE device_has_customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    device_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_device_id FOREIGN KEY (device_id) REFERENCES device(id),
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(id)
);