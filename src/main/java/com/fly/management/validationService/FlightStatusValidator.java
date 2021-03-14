package com.fly.management.validationService;

import com.fly.management.exceptions.UserWrongInputException;

@FunctionalInterface
public interface FlightStatusValidator {
    void checkInput(String flightStatus);
}
