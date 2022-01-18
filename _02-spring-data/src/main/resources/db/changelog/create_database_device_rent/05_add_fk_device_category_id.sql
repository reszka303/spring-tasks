ALTER TABLE device
    ADD device_category_id BIGINT NOT NULL,
    ADD CONSTRAINT fk_device_category_id
    FOREIGN KEY (device_category_id) REFERENCES device_category(id);

