package com.fly.management.service.serviceImpl;

import com.fly.management.entityHelperService.CurrentDateFormatter;
import com.fly.management.exceptions.UserWrongInputException;
import com.fly.management.model.Flight;
import com.fly.management.repository.FlightRepository;
import com.fly.management.service.FlightService;
import com.fly.management.validationService.FlightStatusValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> findAllFlightsByStatusAndAirCompanyName(String status, String airCompanyName) {
        List<Flight> flights = flightRepository.findAllByStatusAndAirCompanyName(status, airCompanyName);
        return flights;
    }

    FlightStatusValidator flightStatusValidator = (flightStatus) -> {
        if (flightStatus != null && !Arrays.asList("ACTIVE", "COMPLETED", "DELAYED", "PENDING").contains(flightStatus)) {
            throw new UserWrongInputException("Wrong flight status: " + flightStatus + " Should by " +
                    "ACTIVE, COMPLETED, DELAYED, PENDING");
        }
    };

    CurrentDateFormatter currentDateFormatter = () -> {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formatter.format(currentDate);
        return currentDate;
    };

    @Override
    public List<Flight> selectAllByFlightStatusAndDepartureTime() {
        List<Flight> flights = flightRepository.selectAllByFlightStatusAndDepartureTime();
        return flights;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        flightStatusValidator.checkInput(flight.getFlightStatus());
        if (flight.getStartedAt().after(flight.getEndedAt())) {
            throw new UserWrongInputException("Incorrect input: starting date of flight : " +
                    flight.getStartedAt() + " is later than " + flight.getEndedAt());
        }
        Flight newFlight = flightRepository.save(flight);
        return newFlight;
    }

    @Override
    public Flight changeFlightStatus(long flightId, String flightStatus) {
        flightStatusValidator.checkInput(flightStatus.toUpperCase());
        Optional<Flight> flightById = flightRepository.findById(flightId);
        if (flightById.isPresent()) {
            Flight flight = flightById.get();
            if (flightStatus.equals("DELAYED")) {
                flight.setDelay(currentDateFormatter.currentDate());
            } else if (flightStatus.equals("ACTIVE")) {
                flight.setStartedAt(currentDateFormatter.currentDate());
            } else if (flightStatus.equals("COMPLETED")) {
                flight.setEndedAt(currentDateFormatter.currentDate());
            }
            flight.setFlightStatus(flightStatus);
            flightRepository.save(flight);
            return flight;
        } else {
            throw new UserWrongInputException("Flight by if: " + flightId + " is not present");
        }
    }

    @Override
    public List<Flight> selectAllFlightsByCompletedStatusAndTimeDifference() {
        List<Flight> flightList = flightRepository.selectAllFlightsByCompletedStatusAndTimeDifference();
        return flightList;
    }
}
