package com.example.listdetails.dto;

public class MortgageProgramListDTO {
    private Long id;
    private String programName;
    private Double interestRate;

    public MortgageProgramListDTO() {}

    public MortgageProgramListDTO(Long id, String programName, Double interestRate) {
        this.id = id;
        this.programName = programName;
        this.interestRate = interestRate;
    }

    public Long getId() { return id; }
    public String getProgramName() { return programName; }
    public Double getInterestRate() { return interestRate; }
}