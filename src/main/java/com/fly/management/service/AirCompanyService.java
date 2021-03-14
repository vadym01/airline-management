package com.fly.management.service;

import com.fly.management.model.AirCompany;

import java.util.List;

public interface AirCompanyService {

    AirCompany saveAirCompany(AirCompany airCompany);

    void deleteAirCompanyById(Long id);

    List<AirCompany> findAll();

    AirCompany findAirCompanyById(Long id);

}
