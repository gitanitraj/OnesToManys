package com.example.listdetails.dto;

public class MortgageProgramDetailDTO {

    private Long id;
    private Long stateId;
    private String programName;
    private String description;
    private Double maxLoan;
    private Double interestRate;

    public MortgageProgramDetailDTO() {}

    public MortgageProgramDetailDTO(Long id,
                                    Long stateId,
                                    String programName,
                                    String description,
                                    Double maxLoan,
                                    Double interestRate) {
        this.id = id;
        this.stateId = stateId;
        this.programName = programName;
        this.description = description;
        this.maxLoan = maxLoan;
        this.interestRate = interestRate;
    }

    public Long getId() { return id; }
    public Long getStateId() { return stateId; }
    public String getProgramName() { return programName; }
    public String getDescription() { return description; }
    public Double getMaxLoan() { return maxLoan; }
    public Double getInterestRate() { return interestRate; }
}