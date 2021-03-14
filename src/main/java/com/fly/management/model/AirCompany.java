package com.fly.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Air company name is required")
    private String name;
    @NotBlank(message = "Company type is required")
    private String companyType;
    @NotNull(message = "Date of foundation is required")
    @DateTimeFormat(pattern="yyyyMMdd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date foundedAt;
    @OneToMany(mappedBy = "airCompany", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flight;
    @OneToMany(mappedBy = "airCompany",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Airplane> airplane;


    public AirCompany(long id, @NotBlank(message = "Air company name is required") String name, @NotBlank(message = "Company type is required") String companyType, @NotNull(message = "Date of foundation is required") Date foundedAt, List<Flight> flight, List<Airplane> airplane) {
        this.id = id;
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
        this.flight = flight;
        this.airplane = airplane;
    }

    public AirCompany(@NotBlank(message = "Air company name is required") String name, @NotBlank(message = "Company type is required") String companyType, @NotNull(message = "Date of foundation is required") Date foundedAt) {
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
    }

    public AirCompany() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Date getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(Date foundedAt) {
        this.foundedAt = foundedAt;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    public List<Airplane> getAirplane() {
        return airplane;
    }

    public void setAirplane(List<Airplane> airplane) {
        this.airplane = airplane;
    }
}
