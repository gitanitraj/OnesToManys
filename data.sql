-- ============================================
-- ListDetails Project: State Housing Support / Mortgage Programs
-- Synthetic Sample Data — Run this AFTER schema.sql
-- ============================================

USE listdetails_db;

-- -----------------------------------------------
-- Seed data for MASTER table: state_housing_support
-- -----------------------------------------------
INSERT INTO state_housing_support (state_name, agency_name, website, phone) VALUES
('Pennsylvania', 'Pennsylvania Housing Finance Agency (PHFA)',         'https://www.phfa.org',    '1-855-827-3466'),
('Delaware',     'Delaware State Housing Authority (DSHA)',            'https://www.destatehousing.com', '302-739-4263'),
('Maryland',     'Maryland Department of Housing and Community Development (DHCD)', 'https://dhcd.maryland.gov', '301-429-7400'),
('New Jersey',   'New Jersey Housing and Mortgage Finance Agency (NJHMFA)', 'https://www.njhousing.gov', '609-278-7400');

-- -----------------------------------------------
-- Seed data for DETAIL table: mortgage_programs
-- state_id matches the ids inserted above
-- -----------------------------------------------
INSERT INTO mortgage_programs (program_name, description, max_loan, interest_rate, state_id) VALUES

-- Pennsylvania (state_id = 1)
('HFA Preferred',           'Low down payment conventional loan for first-time buyers',         484350.00, 6.25, 1),
('Keystone Home Loan',      'Fixed-rate mortgage for first-time and repeat buyers',             379500.00, 6.50, 1),
('Keystone Flex Loan',      'Flexible mortgage combining first and second lien financing',      484350.00, 6.75, 1),

-- Delaware (state_id = 2)
('DSHA Preferred Plus',     'Down payment assistance paired with a first mortgage',             417000.00, 6.40, 2),
('Advantage 4 Program',     'Offers 4% of loan amount as down payment assistance grant',       400000.00, 6.60, 2),
('Welcome Home Loan',       'Affordable mortgage for low-to-moderate income buyers',           350000.00, 6.30, 2),

-- Maryland (state_id = 3)
('Maryland Mortgage Program','State-sponsored 30-year fixed rate first-time buyer loan',       517500.00, 6.20, 3),
('1st Time Advantage Loan', 'Competitive rates with down payment assistance options',          517500.00, 6.35, 3),
('MMP Flex Loan',           'Flexible income limits for buyers in targeted areas',             517500.00, 6.45, 3),

-- New Jersey (state_id = 4)
('First Home Club',         'Matched savings program to help buyers save for down payment',    400000.00, 6.55, 4),
('NJHMFA First-Time Buyer', 'Below-market interest rate for first-time homebuyers in NJ',     484350.00, 6.15, 4),
('Smart Start',             'Down payment and closing cost assistance for eligible buyers',    484350.00, 6.50, 4);