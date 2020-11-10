CREATE TABLE IF NOT EXISTS Brand (
    id          INTEGER                         COMMENT 'Unique id'      PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL    UNIQUE  COMMENT 'Brand name'
);

CREATE TABLE IF NOT EXISTS Product (
    id          INTEGER                         COMMENT 'Unique id'      PRIMARY KEY AUTO_INCREMENT,
    brand_id    INTEGER     NOT NULL            COMMENT 'Brand id',
    name        VARCHAR(50) NOT NULL    UNIQUE  COMMENT 'Product name',
    price       INTEGER     NOT NULL            COMMENT 'Product price',
    quantity    INTEGER     NOT NULL            COMMENT 'Product quantity',
    FOREIGN KEY (brand_id) REFERENCES Brand (id)
);

CREATE INDEX IX_Product_Name ON Product (name);