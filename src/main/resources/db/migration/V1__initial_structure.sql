CREATE TABLE car_brands
(
    id               VARCHAR(36) PRIMARY KEY,
    name             VARCHAR(50) NOT NULL UNIQUE,
    display_name     VARCHAR(100),
    created_by       VARCHAR(255),
    created_on       TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_on TIMESTAMP
);

CREATE TABLE car_models
(
    id           VARCHAR(36) PRIMARY KEY,
    name         VARCHAR(50) NOT NULL,
    display_name VARCHAR(100),
    start_year   INTEGER     NOT NULL CHECK (start_year > 1900),
    end_year     INTEGER CHECK (end_year IS NULL OR end_year > 1900),
    brand_id     VARCHAR(36) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES car_brands (id)
);

CREATE TABLE car_listing
(
    id    VARCHAR(36) PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    year  INTEGER      NOT NULL CHECK (year > 1900),
    price DECIMAL(10,2) NOT NULL CHECK (price > 0),
    mileage INTEGER NOT NULL CHECK (mileage >= 0),
    fuel_type VARCHAR(20) NOT NULL,
    transmission VARCHAR(20) NOT NULL,
    is_featured BOOLEAN NOT NULL DEFAULT FALSE,
    brand_id VARCHAR(36) NOT NULL,
    model_id VARCHAR(36) NOT NULL,
    created_by VARCHAR(255),
    created_on TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_on TIMESTAMP,
    FOREIGN KEY (brand_id) REFERENCES car_brands(id),
    FOREIGN KEY (model_id) REFERENCES car_models(id)
);