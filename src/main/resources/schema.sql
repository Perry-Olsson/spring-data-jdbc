CREATE TABLE IF NOT EXISTS customer (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS product (
     id LONG AUTO_INCREMENT PRIMARY KEY,
     sku LONG NOT NULL UNIQUE,
     name VARCHAR(200) NOT NULL,
     description VARCHAR(4000)
);

CREATE TABLE IF NOT EXISTS purchase (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    customer_id LONG,
    product_id LONG,
    cancelled bool NOT NULL DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
