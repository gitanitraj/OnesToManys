package com.example.listdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mortgage_program")
public class MortgageProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String programName;
    private String description;
    private Double interestRate;
    private Double maxLoanAmount;
    private Integer termYears;
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_housing_support_id", nullable = false)
    private StateHousingSupport stateHousingSupport;

    public MortgageProgram() {}

    public MortgageProgram(Long id,
            StateHousingSupport stateHousingSupport,
            String programName,
            String description,
            Double interestRate,
            Double maxLoanAmount,
            Integer termYears,
            Boolean active) {
        this.id = id;
        this.stateHousingSupport = stateHousingSupport;
        this.programName = programName;
        this.description = description;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.termYears = termYears;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getProgramName() { return programName; }
    public String getDescription() { return description; }
    public Double getInterestRate() { return interestRate; }
    public Double getMaxLoanAmount() { return maxLoanAmount; }
    public Integer getTermYears() { return termYears; }
    public Boolean getActive() { return active; }
    public StateHousingSupport getStateHousingSupport() { return stateHousingSupport; }

    public void setProgramName(String programName) { this.programName = programName; }
    public void setDescription(String description) { this.description = description; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }
    public void setMaxLoanAmount(Double maxLoanAmount) { this.maxLoanAmount = maxLoanAmount; }
    public void setTermYears(Integer termYears) { this.termYears = termYears; }
    public void setActive(Boolean active) { this.active = active; }
    public void setStateHousingSupport(StateHousingSupport stateHousingSupport) {
        this.stateHousingSupport = stateHousingSupport;
    }
}