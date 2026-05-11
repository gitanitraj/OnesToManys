-- ============================================
-- ListDetails Project: Product Category / Products
-- Schema File
-- ============================================

-- Start fresh each time (for development/testing)
DROP DATABASE IF EXISTS listdetails_db;
CREATE DATABASE listdetails_db;
USE listdetails_db;

-- -----------------------------------------------
-- MASTER TABLE: product_categories
-- Think of this like a folder that holds products
-- -----------------------------------------------
CREATE TABLE product_categories (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)  NOT NULL,
    description VARCHAR(255)
);

-- -----------------------------------------------
-- DETAIL TABLE: products
-- Each product belongs to one category (via category_id)
-- category_id is the "string" connecting it to its folder
-- -----------------------------------------------
CREATE TABLE products (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)  NOT NULL,
    description VARCHAR(255),
    price       DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,

    -- This foreign key links each product to its category
    FOREIGN KEY (category_id) REFERENCES product_categories(id)
        ON DELETE CASCADE
);
