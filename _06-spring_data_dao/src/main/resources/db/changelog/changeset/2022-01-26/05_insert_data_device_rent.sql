-- liquibase formatted sql
-- changeset javastart:1

INSERT INTO customer(id, first_name, last_name, pesel, id_number) VALUES (1, 'Jan', 'Kowalski', '90908765123', 'ABC678123');
INSERT INTO customer(id, first_name, last_name, pesel, id_number) VALUES(2, 'Piotr', 'Adamski', '12345678911', 'ABC123456');

INSERT INTO device_category(id, name, description) VALUES (1, 'Elektronarzędzia', 'Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia');
INSERT INTO device_category(id, name, description) VALUES (2, 'Narzędzia', 'Narzędzia ręczne, narzędzia pomiarowe, narzędzia motoryzacyjne i narzędzia motoryzacyjne');

INSERT INTO device (name, description, quantity, price, device_category_id) VALUES('Wiertarka udarowa Bosch GSB 24-2', 'Wiertarka udarowa o dużej mocy 3000W z zestawem wierteł w komplecie', 5, 238.50, 1);
INSERT INTO device (name, description, quantity, price, device_category_id) VALUES ('Imadło wielofunkcyjne', 'Imadło wielofunkcyjne obrotowe 4 Yato YT-6505', 8, 279, 2);


INSERT INTO device_has_customer(device_id, customer_id) VALUES (1,1);
INSERT INTO device_has_customer(device_id, customer_id) VALUES (2,2)