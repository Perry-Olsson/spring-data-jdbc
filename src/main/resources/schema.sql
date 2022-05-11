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

CREATE TABLE IF NOT EXISTS product_v2_type (
    product_type_id LONG PRIMARY KEY,
    product_type    VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS product_v2 (
    product_id LONG AUTO_INCREMENT PRIMARY KEY,
    product_type_id LONG REFERENCES product_v2_type(product_type_id),
    sku LONG NOT NULL UNIQUE,
    name VARCHAR(200),
    description TEXT
);

CREATE TABLE IF NOT EXISTS book (
    product_id LONG AUTO_INCREMENT PRIMARY KEY,
    product_type_id LONG DEFAULT 1,
    pages INT,
    FOREIGN KEY (product_id, product_type_id) REFERENCES product_v2(product_id, product_type_id),
    CHECK (product_type_id = 1)
);

CREATE TABLE IF NOT EXISTS sports_equipment (
    product_id LONG PRIMARY KEY,
    product_type_id LONG DEFAULT 2,
    sport VARCHAR(100),
    FOREIGN KEY (product_id, product_type_id) REFERENCES product_v2(product_id, product_type_id),
    CHECK (product_type_id = 2)
) ;

CREATE TABLE IF NOT EXISTS purchase (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    customer_id LONG,
    product_id LONG,
    cancelled bool NOT NULL DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
