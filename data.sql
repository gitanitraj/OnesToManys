-- ============================================
-- ListDetails Project: Synthetic Sample Data
-- Run this AFTER schema.sql
-- ============================================

USE listdetails_db;

-- -----------------------------------------------
-- Seed data for MASTER table: product_categories
-- -----------------------------------------------
INSERT INTO product_categories (name, description) VALUES
('Electronics',   'Gadgets, devices, and tech accessories'),
('Clothing',      'Shirts, pants, shoes, and outerwear'),
('Home & Garden', 'Furniture, tools, and outdoor supplies'),
('Sports',        'Equipment and gear for athletic activities'),
('Books',         'Fiction, nonfiction, textbooks, and more');

-- -----------------------------------------------
-- Seed data for DETAIL table: products
-- Notice how category_id matches the ids above
-- -----------------------------------------------
INSERT INTO products (name, description, price, category_id) VALUES
-- Electronics (category_id = 1)
('Wireless Headphones', 'Noise-cancelling over-ear headphones', 79.99,  1),
('USB-C Hub',           '7-in-1 multiport adapter',             34.99,  1),
('Mechanical Keyboard', 'Compact tenkeyless with RGB lighting', 59.99,  1),

-- Clothing (category_id = 2)
('Denim Jacket',    'Classic blue denim, unisex fit',       49.99,  2),
('Running Shoes',   'Lightweight with cushioned sole',      89.99,  2),
('Graphic T-Shirt', 'Cotton blend, assorted designs',       19.99,  2),

-- Home & Garden (category_id = 3)
('Garden Hose',     '50ft expandable with spray nozzle',   29.99,  3),
('Bookshelf',       '5-tier wooden shelf, walnut finish',  119.99, 3),
('LED Desk Lamp',   'Adjustable brightness and color temp', 24.99,  3),

-- Sports (category_id = 4)
('Yoga Mat',        'Non-slip, 6mm thick, eco-friendly',   22.99,  4),
('Dumbbell Set',    '5-25lb pairs with rack',             149.99,  4),
('Jump Rope',       'Speed rope with ball bearings',        12.99,  4),

-- Books (category_id = 5)
('Clean Code',          'R. Martin - software best practices', 35.99, 5),
('The Pragmatic Programmer', 'Hunt & Thomas - career advice',  42.99, 5),
('Java: A Beginners Guide', 'Herbert Schildt - intro to Java', 39.99, 5);
