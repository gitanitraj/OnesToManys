package com.example.listdetails.dto;

public class MortgageProgramListDTO {
    private Long id;
    private String programName;
    private String description;
    private Double interestRate;
    private Double maxLoanAmount;
    private Integer termYears;
    private Boolean active;
    private Long stateId;
    private String stateName;

    public MortgageProgramListDTO() {}

    public MortgageProgramListDTO(Long id, String programName, String description,
                                   Double interestRate, Double maxLoanAmount,
                                   Integer termYears, Boolean active,
                                   Long stateId, String stateName) {
        this.id = id;
        this.programName = programName;
        this.description = description;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.termYears = termYears;
        this.active = active;
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Long getId() { return id; }
    public String getProgramName() { return programName; }
    public String getDescription() { return description; }
    public Double getInterestRate() { return interestRate; }
    public Double getMaxLoanAmount() { return maxLoanAmount; }
    public Integer getTermYears() { return termYears; }
    public Boolean getActive() { return active; }
    public Long getStateId() { return stateId; }
    public String getStateName() { return stateName; }
}