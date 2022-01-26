-- liquibase formatted sql
-- changeset javastart:1

CREATE TABLE device_has_customer (
    device_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_device_id
    FOREIGN KEY (device_id) REFERENCES device (id),
    CONSTRAINT fk_customer_id
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);