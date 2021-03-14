package com.fly.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Airplane name is required")
    private String name;
    @NotNull(message = "Factory serial number is required")
    private String factorySerialNumber;
    @NotNull(message = "Number of flights is required")
    private int numberOfFlights;
    @NotNull(message = "Flight distance value is required")
    private double flightDistance;
    @NotNull(message = "Fuel capacity is required")
    private double fuelCapacity;
    @NotBlank(message = "Type is required")
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @OneToMany(mappedBy = "airplane", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flight;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    public Airplane(long id, @NotBlank(message = "Airplane name is required") String name, @NotNull(message = "Factory serial number is required") String factorySerialNumber, @NotNull(message = "Number of flights is required") int numberOfFlights, @NotNull(message = "Flight distance value is required") double flightDistance, @NotNull(message = "Fuel capacity is required") double fuelCapacity, @NotBlank(message = "Type is required") String type, Date createdAt, List<Flight> flight, AirCompany airCompany) {
        this.id = id;
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
        this.flight = flight;
        this.airCompany = airCompany;
    }

    public Airplane(@NotBlank(message = "Airplane name is required") String name, @NotNull(message = "Factory serial number is required") String factorySerialNumber, @NotNull(message = "Number of flights is required") int numberOfFlights, @NotNull(message = "Flight distance value is required") double flightDistance, @NotNull(message = "Fuel capacity is required") double fuelCapacity, @NotBlank(message = "Type is required") String type, Date createdAt, List<Flight> flight, AirCompany airCompany) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
        this.flight = flight;
        this.airCompany = airCompany;
    }

    public Airplane() {
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

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public double getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(double flightDistance) {
        this.flightDistance = flightDistance;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }
}
