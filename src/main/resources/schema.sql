DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);