package com.example.listdetails.dto;

public class MortgageProgramDetailDTO {

    private Long id;
    private Long stateId;
    private String stateName;
    private String programName;
    private String description;
    private Double interestRate;
    private Double maxLoanAmount;
    private Integer termYears;
    private Boolean active;

    public MortgageProgramDetailDTO() {}

    public MortgageProgramDetailDTO(Long id,
                                    Long stateId,
                                    String stateName,
                                    String programName,
                                    String description,
                                    Double interestRate,
                                    Double maxLoanAmount,
                                    Integer termYears,
                                    Boolean active) {
        this.id = id;
        this.stateId = stateId;
        this.stateName = stateName;
        this.programName = programName;
        this.description = description;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.termYears = termYears;
        this.active = active;
    }

    public Long getId() { return id; }
    public Long getStateId() { return stateId; }
    public String getStateName() { return stateName; }
    public String getProgramName() { return programName; }
    public String getDescription() { return description; }
    public Double getMaxLoanAmount() { return maxLoanAmount; }
    public Double getInterestRate() { return interestRate; }
    public Integer getTermYears() { return termYears; }
    public Boolean getActive() { return active; }
}
