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
INSERT INTO purchase (id, customer_id, product_id, cancelled) VALUES(5, 2, 2, true);

INSERT INTO product_v2_type (product_type_id, product_type) VALUES (1, 'BOOK');
INSERT INTO product_v2_type (product_type_id, product_type) VALUES (2, 'SPORTS_EQUIPMENT');

-- insert books
INSERT INTO product_v2 (product_id, product_type_id, sku, name, description) VALUES (1, 1, 10, 'The Old Man and the Sea', 'Good book');
INSERT INTO book (product_id, product_type_id, pages) VALUES (1, 1, 150);
INSERT INTO product_v2 (product_id, product_type_id, sku, name, description) VALUES (2, 1, 20, 'The Great Gatsby', 'Also a good book');
INSERT INTO book (product_id, product_type_id, pages) VALUES (2, 1, 220);

-- insert sports equipment
INSERT INTO product_v2 (product_id, product_type_id, sku, name) VALUES (3, 2, 30, 'Spalding Basketball');
INSERT INTO sports_equipment (product_id, product_type_id, sport) VALUES (3, 2, 'basketball');
INSERT INTO product_v2 (product_id, product_type_id, sku, name, description) VALUES (4, 2, 40, 'Soccer Ball', 'Full sized black and white soccer ball');
INSERT INTO sports_equipment (product_id, product_type_id, sport) VALUES (4, 2, 'soccer');
INSERT INTO product_v2 (product_id, product_type_id, sku, name, description) VALUES (5, 2, 50, 'Standard Baseball', 'Standard size leather stitched baseball');
INSERT INTO sports_equipment (product_id, product_type_id, sport) VALUES (5, 2, 'baseball');
