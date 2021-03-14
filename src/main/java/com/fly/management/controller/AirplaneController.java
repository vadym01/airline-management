package com.fly.management.controller;

import com.fly.management.model.Airplane;
import com.fly.management.service.AirplaneService;
import com.fly.management.validationService.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private MapValidationService mapValidationService;

    @PostMapping
    public ResponseEntity saveAirplane(@Valid @RequestBody Airplane airplane, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationService.mapValidationService(bindingResult);
        if (errorMap != null) return errorMap;
        Airplane newAirplane = airplaneService.saveAirplane(airplane);
        return new ResponseEntity(newAirplane, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity findAirplaneById(@PathVariable("id") long id) {
        Airplane airplane = airplaneService.findAirplaneById(id);
        return new ResponseEntity(airplane, HttpStatus.OK);
    }

    @PutMapping("{airplaneId}/{companyId}")
    public ResponseEntity resetAirplaneCompanyDependence(@PathVariable("airplaneId") long airplaneId,
                                                         @PathVariable("companyId") long companyId) {
        Airplane airplane = airplaneService.moveAirplaneToCompany(airplaneId, companyId);
        return new ResponseEntity(airplane, HttpStatus.OK);
    }
}
