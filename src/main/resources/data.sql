INSERT INTO customer (id, first_name, last_name) VALUES (1, 'John', 'Doe');
INSERT INTO customer (id, first_name, last_name) VALUES (2, 'Jimmy', 'John');
INSERT INTO customer (id, first_name, last_name) VALUES (3, 'Cindy', 'Lauper');

INSERT INTO product (id, sku, name) VALUES (1, 1, 'basketball');
INSERT INTO product (id, sku, name, description) VALUES (2, 2, 'soccer ball', 'Full sized black and white soccer ball');
INSERT INTO product (id, sku, name, description) VALUES (3, 3, 'baseball', 'Standard size leather stitched baseball');

INSERT INTO purchase (id, customer_id, product_id) VALUES (1, 2, 3);
INSERT INTO purchase (id, customer_id, product_id) VALUES (2, 2, 1);
INSERT INTO purchase (id, customer_id, product_id) VALUES (3, 1, 2);
INSERT INTO purchase (id, customer_id, product_id, cancelled) VALUES (4, 2, 1, true);
