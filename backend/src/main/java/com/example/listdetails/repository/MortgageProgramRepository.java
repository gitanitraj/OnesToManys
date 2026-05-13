package com.example.listdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.listdetails.model.MortgageProgram;

public interface MortgageProgramRepository extends JpaRepository<MortgageProgram, Long> {

    // This method name MUST match your entity field name: "state"
    List<MortgageProgram> findByStateHousingSupportId(Long stateId);
}
