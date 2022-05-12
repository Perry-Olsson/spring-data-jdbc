CREATE TABLE IF NOT EXISTS customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS product_category (
    category_name VARCHAR(60) PRIMARY KEY,
    category_description VARCHAR(4000)
);

CREATE TABLE IF NOT EXISTS product (
     id INT AUTO_INCREMENT PRIMARY KEY,
     sku INT NOT NULL UNIQUE,
     name VARCHAR(200) NOT NULL,
     description VARCHAR(4000),
     category_name VARCHAR(60) REFERENCES product_category(category_name)
);

CREATE TABLE IF NOT EXISTS purchase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    cancelled bool NOT NULL DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
