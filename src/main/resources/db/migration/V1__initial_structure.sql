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

CREATE TABLE listing (
    id VARCHAR(36) PRIMARY KEY,
    listing_type VARCHAR(31) NOT NULL,
    title VARCHAR(200) NOT NULL,
    year INTEGER NOT NULL CHECK (year > 1900),
    price DECIMAL(10,2) NOT NULL CHECK (price > 0),
    mileage INTEGER NOT NULL CHECK (mileage >= 0),
    fuel_type VARCHAR(20) NOT NULL,
    transmission VARCHAR(20) NOT NULL,
    featured BOOLEAN NOT NULL DEFAULT FALSE,
    created_by VARCHAR(255),
    created_on TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_on TIMESTAMP
);

CREATE TABLE car_listing (
    id VARCHAR(36) PRIMARY KEY,
    brand_id VARCHAR(36) NOT NULL,
    model_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (id) REFERENCES listing(id),
    FOREIGN KEY (brand_id) REFERENCES car_brands(id),
    FOREIGN KEY (model_id) REFERENCES car_models(id)
);

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    display_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_by VARCHAR(255),
    created_on TIMESTAMP,
    last_modified_by VARCHAR(255),
    last_modified_on TIMESTAMP
);

CREATE TABLE user_observed_listings (
    user_id BIGINT NOT NULL,
    listing_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (user_id, listing_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (listing_id) REFERENCES car_listing(id)
);