package com.fly.management.repository;

import com.fly.management.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = ?1 AND f.airCompany.name = ?2")
    List<Flight> findAllByStatusAndAirCompanyName(String flightStatus, String name);

    @Query(value = "SELECT * FROM Flight f WHERE f.flight_status = 'ACTIVE' AND f.started_at < NOW() + '24 hour'", nativeQuery = true)
    List<Flight> selectAllByFlightStatusAndDepartureTime();

    @Query(value = "SELECT * FROM flight f WHERE f.flight_status = 'COMPLETED' AND  TIMESTAMPDIFF(MINUTE, f.started_at, f.ended_at) > f.estimated_flight_time", nativeQuery = true)
    List<Flight> selectAllFlightsByCompletedStatusAndTimeDifference();

}
