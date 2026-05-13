package com.example.listdetails.dto;

public class StateHousingSupportDetailDTO {

    private Long id;
    private String stateName;
    private String agencyName;
    private String website;
    private String phone;

    public StateHousingSupportDetailDTO() {}

    public StateHousingSupportDetailDTO(Long id,
                                        String stateName,
                                        String agencyName,
                                        String website,
                                        String phone) {
        this.id = id;
        this.stateName = stateName;
        this.agencyName = agencyName;
        this.website = website;
        this.phone = phone;
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

    public String getWebsite() {
        return website;
    }

    public String getPhone() {
        return phone;
    }
}
