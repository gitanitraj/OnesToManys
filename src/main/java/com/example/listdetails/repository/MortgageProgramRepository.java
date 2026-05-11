package com.example.listdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.listdetails.model.MortgageProgram;
 
public interface MortgageProgramRepository extends JpaRepository<MortgageProgram, Long> {
}

