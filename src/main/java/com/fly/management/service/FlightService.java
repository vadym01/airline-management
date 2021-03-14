package com.fly.management.service;

import com.fly.management.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAllFlightsByStatusAndAirCompanyName(String status, String name);

    List<Flight> selectAllByFlightStatusAndDepartureTime();

    Flight saveFlight(Flight flight);

    Flight changeFlightStatus(long flightId, String flightStatus);

    List<Flight> selectAllFlightsByCompletedStatusAndTimeDifference();





}
