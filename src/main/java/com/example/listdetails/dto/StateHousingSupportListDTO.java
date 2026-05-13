package com.example.listdetails.dto;

public class StateHousingSupportListDTO {

    private Long id;
    private String stateName;
    private String agencyName;

    public StateHousingSupportListDTO() {}

    public StateHousingSupportListDTO(Long id, String stateName, String agencyName) {
        this.id = id;
        this.stateName = stateName;
        this.agencyName = agencyName;
    }

    public Long getId() {
        return id;
    }

    public String getStateName() {
        return stateName;
    }

    public String getAgencyName() {
        return agencyName;
    }
}
