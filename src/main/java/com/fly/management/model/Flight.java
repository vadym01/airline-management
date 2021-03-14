package com.fly.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightStatus;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @NotBlank(message = "Departure country is required")
    private String departureCountry;
    @NotBlank(message = "Destination country is required")
    private String destinationCountry;
    @DecimalMin(value = "1.0", message = "distance is required")
    private double distance;
    @DecimalMin(value = "1.0", message = "Estimated flight time is required")
    private double estimatedFlightTime;
    private Date startedAt;
    private Date endedAt;
    private Date delay;
    private Date createdAt;

    public Flight(long id, String flightStatus, AirCompany airCompany, Airplane airplane, String departureCountry, String destinationCountry, double distance, double estimatedFlightTime, Date startedAt, Date endedAt, Date delay, Date createdAt) {
        this.id = id;
        this.flightStatus = flightStatus;
        this.airCompany = airCompany;
        this.airplane = airplane;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.delay = delay;
        this.createdAt = createdAt;
    }

    public Flight(String departureCountry, String destinationCountry, double distance, double estimatedFlightTime, Date startedAt, Date endedAt, Date delay, Date createdAt) {
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estimatedFlightTime = estimatedFlightTime;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.delay = delay;
        this.createdAt = createdAt;
    }

    public Flight() {
    }

    @PrePersist
    void preInsert() {
        if (this.flightStatus == null)
            this.flightStatus = "PENDING";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(double estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public Date getDelay() {
        return delay;
    }

    public void setDelay(Date delay) {
        this.delay = delay;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
