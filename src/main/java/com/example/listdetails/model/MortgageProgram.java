package com.example.listdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mortgage_programs")
public class MortgageProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String programName;
    private String description;
    private Double maxLoan;
    private Double interestRate;

    // Links each mortgage program back to its state housing agency
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private StateHousingSupport state;

    // --- Constructors ---
    public MortgageProgram() {}

    public MortgageProgram(String programName, String description, Double maxLoan, Double interestRate, StateHousingSupport state) {
        this.programName = programName;
        this.description = description;
        this.maxLoan = maxLoan;
        this.interestRate = interestRate;
        this.state = state;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getMaxLoan() { return maxLoan; }
    public void setMaxLoan(Double maxLoan) { this.maxLoan = maxLoan; }

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public StateHousingSupport getState() { return state; }
    public void setState(StateHousingSupport state) { this.state = state; }
}
