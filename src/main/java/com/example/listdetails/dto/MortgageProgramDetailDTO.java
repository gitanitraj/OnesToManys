package com.example.listdetails.dto;

public class MortgageProgramDetailDTO {

    private Long id;
    private Long stateHousingSupportId;
    private String programName;
    private Double interestRate;
    private Double maxLoanAmount;
    private Integer termYears;
    private Boolean active;

    // getters and setters
    public MortgageProgramDetailDTO() {}

    public Long getID() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStateHousingSupportId() { return stateHousingSupportId; }
    public void setStateHousingSupportId(Long stateHousingSupportId) { this.stateHousingSupportId = stateHousingSupportId; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public Double getMaxLoanAmount() { return maxLoanAmount; }
    public void setMaxLoanAmount(Double maxLoanAmount) { this.maxLoanAmount = maxLoanAmount; }

    public Integer getTermYears() { return termYears; }
    public void setTermYears(Integer termYears) { this.termYears = termYears; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
