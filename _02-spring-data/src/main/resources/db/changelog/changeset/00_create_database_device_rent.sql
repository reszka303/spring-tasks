CREATE TABLE customer (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(45) NOT NULL,
                          last_name VARCHAR(45) NOT NULL,
                          pesel VARCHAR(11) NOT NULL,
                          id_number VARCHAR(10) NOT NULL
);

CREATE TABLE device_category (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 name VARCHAR(255) NOT NULL,
                                 description VARCHAR(1024) NOT NULL
);


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


