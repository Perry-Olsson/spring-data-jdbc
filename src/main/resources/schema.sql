DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
     id LONG AUTO_INCREMENT PRIMARY KEY,
     sku LONG NOT NULL UNIQUE,
     name VARCHAR(200) NOT NULL,
     description TEXT
);
--
-- DROP TABLE IF EXISTS purchase;
-- CREATE TABLE purchase (
--     id LONG AUTO_INCREMENT PRIMARY KEY,
--     customer_id LONG,
--     product_id LONG,
--     FOREIGN KEY (customer_id) REFERENCES customer(id),
--     FOREIGN KEY (product_id) REFERENCES product(id)
-- );
