package com.example.listdetails.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "state_housing_support")
public class StateHousingSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stateName;
    private String agencyName;
    private String website;
    private String phone;

    @OneToMany(
            mappedBy = "stateHousingSupport",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MortgageProgram> mortgagePrograms;

    public StateHousingSupport() {}

    public StateHousingSupport(String stateName, String agencyName, String website, String phone) {
        this.stateName = stateName;
        this.agencyName = agencyName;
        this.website = website;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getStateName() { return stateName; }
    public String getAgencyName() { return agencyName; }
    public String getWebsite() { return website; }
    public String getPhone() { return phone; }
    public List<MortgageProgram> getMortgagePrograms() { return mortgagePrograms; }

    public void setStateName(String stateName) { this.stateName = stateName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }
    public void setWebsite(String website) { this.website = website; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setMortgagePrograms(List<MortgageProgram> mortgagePrograms) {
        this.mortgagePrograms = mortgagePrograms;
    }
}
