package com.fly.management.controller;

import com.fly.management.model.Flight;
import com.fly.management.repository.FlightRepository;
import com.fly.management.service.FlightService;
import com.fly.management.validationService.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private MapValidationService mapValidationService;

    @PostMapping
    public ResponseEntity saveFlight(@Valid @RequestBody Flight flight, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationService.mapValidationService(bindingResult);
        if (errorMap != null) return errorMap;
        Flight newFlight = flightService.saveFlight(flight);
        return new ResponseEntity(newFlight, HttpStatus.OK);
    }

    @GetMapping("{flightStatus}/{companyName}")
    public ResponseEntity findAllFlightsByStatusAndAirCompanyName(@PathVariable("flightStatus") String flightStatus,
                                                                  @PathVariable("companyName") String companyName) {
        List<Flight> flightList = flightService.findAllFlightsByStatusAndAirCompanyName(flightStatus, companyName);
        return new ResponseEntity(flightList, HttpStatus.OK);
    }

    @GetMapping("all/active-departure")
    public ResponseEntity selectAllByFlightStatusAndDepartureTime() {
        List<Flight> flightList = flightService.selectAllByFlightStatusAndDepartureTime();
        return new ResponseEntity(flightList, HttpStatus.OK);
    }

    @PutMapping("{flightId}/{flightStatus}")
    public ResponseEntity changeFlightStatus(@PathVariable("flightId") long flightId,
                                             @PathVariable("flightStatus") String flightStatus) {
        Flight flight = flightService.changeFlightStatus(flightId, flightStatus);
        return new ResponseEntity(flight, HttpStatus.OK);
    }

    @GetMapping("completed-status/time-difference")
    public ResponseEntity selectAllFlightsByCompletedStatusAndTimeDifference() {
        List<Flight> flightList = flightService.selectAllFlightsByCompletedStatusAndTimeDifference();
        System.out.println(flightList);
        return new ResponseEntity(flightList, HttpStatus.OK);
    }


}
