-- ============================================
-- ListDetails Project: State Housing Support / Mortgage Programs
-- Schema File
-- ============================================
 
DROP DATABASE IF EXISTS listdetails_db;
CREATE DATABASE listdetails_db;
USE listdetails_db;
 
-- -----------------------------------------------
-- MASTER TABLE: state_housing_support
-- Each row is a state housing agency
-- -----------------------------------------------
CREATE TABLE state_housing_support (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    state_name   VARCHAR(100) NOT NULL,
    agency_name  VARCHAR(255) NOT NULL,
    website      VARCHAR(255),
    phone        VARCHAR(20)
);
 
-- -----------------------------------------------
-- DETAIL TABLE: mortgage_program
-- Each program belongs to one state housing agency
-- state_housing_support_id is the foreign key linking it to master
-- -----------------------------------------------
CREATE TABLE mortgage_program (
    id                       INT AUTO_INCREMENT PRIMARY KEY,
    program_name             VARCHAR(255) NOT NULL,
    description              VARCHAR(500),
    interest_rate            DECIMAL(5, 2),
    max_loan_amount          DECIMAL(12, 2),
    term_years               INT,
    active                   BOOLEAN,
    state_housing_support_id INT NOT NULL,
 
    FOREIGN KEY (state_housing_support_id) REFERENCES state_housing_support(id)
        ON DELETE CASCADE
);
