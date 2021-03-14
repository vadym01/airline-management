package com.fly.management;

import com.fly.management.model.AirCompany;
import com.fly.management.model.Airplane;
import com.fly.management.model.Flight;
import com.fly.management.repository.AirCompanyRepository;
import com.fly.management.repository.AirplaneRepository;
import com.fly.management.repository.FlightRepository;
import com.fly.management.service.AirCompanyService;
import com.fly.management.service.AirplaneService;
import com.fly.management.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ManagementApplicationTests {


    Airplane airplane;
    Flight flight;
    AirCompany airCompany;


    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
//		LocalDate myDate =LocalDate.parse("2014-02-14");
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm ");

//        airCompany = new AirCompany("Aurora Airlines", "International", new Date());
//
//        airplane = new Airplane( "AN 24", "A235", 23, 1234, 234, "heavy", new Date(), flight, airCompany);
//        flight = new Flight("ACTIVE","USA", 2345, 1243, new Date(), new Date(), new Date(), new Date());

    }

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AirCompanyService airCompanyService;

    @Autowired
    private AirplaneRepository airplaneRepository;


    @Test
    void saveNewAirCompany() {
        airCompanyService.saveAirCompany(airCompany);
    }


    @Test
    void saveNewFlight() {
//        flightRepository.save(flight);
        flightService.saveFlight(flight);
    }

    @Test
    void saveNewAirplane() {
        airplaneService.saveAirplane(airplane);
    }

    @Test
    void findAllFlightsByStatusAndAirCompanyName() {
        System.out.println(flightService.findAllFlightsByStatusAndAirCompanyName("PENDING", "Airline"));
    }

    @Test
    void selectAllByFlightStatusAndDepartureTime() {
        System.out.println( flightService.selectAllByFlightStatusAndDepartureTime());
    }

    @Test
    void changeFlightStatus(){
        System.out.println(flightService.changeFlightStatus(19,"COMPLETED"));
    }

}
