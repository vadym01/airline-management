package com.fly.management.controller;

import com.fly.management.model.AirCompany;
import com.fly.management.service.AirCompanyService;
import com.fly.management.validationService.MapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class AirCompanyController {

    @Autowired
    private AirCompanyService airCompanyService;

//    @Autowired
//    private ConverterService converterService;

    @Autowired
    private MapValidationService mapValidationService;

    @PostMapping
    public ResponseEntity<?> saveAirCompany(@Valid @RequestBody AirCompany airCompany, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationService.mapValidationService(bindingResult);
        if(errorMap != null) return errorMap;
        airCompanyService.saveAirCompany(airCompany);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAirCompanyById(@PathVariable("id") long id) {
        airCompanyService.deleteAirCompanyById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllAirCompanies() {
        List<AirCompany> airCompanyList = airCompanyService.findAll();
        return new ResponseEntity(airCompanyList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity findAirCompanyById(@PathVariable("id") long id)  {
        AirCompany airCompany = airCompanyService.findAirCompanyById(id);
        return new ResponseEntity(airCompany, HttpStatus.OK);
    }
}
