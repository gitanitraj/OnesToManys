-- ============================================
-- ListDetails Project: State Housing Support / Mortgage Programs
-- Synthetic Sample Data — Run this AFTER schema.sql
-- ============================================

-- -----------------------------------------------
-- Seed data for MASTER table: state_housing_support
-- -----------------------------------------------
INSERT INTO state_housing_support (state_name, agency_name, website, phone) VALUES
('Pennsylvania', 'Pennsylvania Housing Finance Agency (PHFA)',         'https://www.phfa.org',    '1-855-827-3466'),
('Delaware',     'Delaware State Housing Authority (DSHA)',            'https://www.destatehousing.com', '302-739-4263'),
('Maryland',     'Maryland Department of Housing and Community Development (DHCD)', 'https://dhcd.maryland.gov', '301-429-7400'),
('New Jersey',   'New Jersey Housing and Mortgage Finance Agency (NJHMFA)', 'https://www.njhousing.gov', '609-278-7400');

-- -----------------------------------------------
-- Seed data for DETAIL table: mortgage_program
-- state_housing_support_id matches the ids inserted above
-- -----------------------------------------------
INSERT INTO mortgage_program (program_name, description, interest_rate, max_loan_amount, term_years, active, state_housing_support_id) VALUES

-- Pennsylvania (state_housing_support_id = 1)
('HFA Preferred',      'Low down payment conventional loan for first-time buyers',  6.25, 484350.00, 30, true, 1),
('Keystone Home Loan', 'Fixed-rate mortgage for first-time and repeat buyers',       6.50, 379500.00, 30, true, 1),
('Keystone Flex Loan', 'Flexible mortgage combining first and second lien financing',6.75, 484350.00, 30, true, 1),

-- Delaware (state_housing_support_id = 2)
('DSHA Preferred Plus','Down payment assistance paired with a first mortgage',       6.40, 417000.00, 30, true, 2),
('Advantage 4 Program','Offers 4% of loan amount as down payment assistance grant', 6.60, 400000.00, 30, true, 2),
('Welcome Home Loan',  'Affordable mortgage for low-to-moderate income buyers',     6.30, 350000.00, 30, true, 2),

-- Maryland (state_housing_support_id = 3)
('Maryland Mortgage Program','State-sponsored 30-year fixed rate first-time buyer loan', 6.20, 517500.00, 30, true, 3),
('1st Time Advantage Loan',  'Competitive rates with down payment assistance options',   6.35, 517500.00, 30, true, 3),
('MMP Flex Loan',            'Flexible income limits for buyers in targeted areas',      6.45, 517500.00, 30, true, 3),

-- New Jersey (state_housing_support_id = 4)
('First Home Club',         'Matched savings program to help buyers save for down payment', 6.55, 400000.00, 30, true, 4),
('NJHMFA First-Time Buyer', 'Below-market interest rate for first-time homebuyers in NJ',  6.15, 484350.00, 30, true, 4),
('Smart Start',             'Down payment and closing cost assistance for eligible buyers', 6.50, 484350.00, 30, true, 4);