package com.fly.management.service.serviceImpl;

import com.fly.management.exceptions.UserWrongInputException;
import com.fly.management.model.AirCompany;
import com.fly.management.model.Airplane;
import com.fly.management.repository.AirplaneRepository;
import com.fly.management.service.AirCompanyService;
import com.fly.management.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirCompanyService airCompanyService;

    @Override
    public Airplane saveAirplane(Airplane airplane) {
        Airplane newAirplane = airplaneRepository.save(airplane);
        return newAirplane;
    }

    @Override
    public Airplane findAirplaneById(long airplaneId) {
        Optional<Airplane> airplane = airplaneRepository.findById(airplaneId);
        if (airplane.isPresent()) {
            return airplane.get();
        } else {
            throw new UserWrongInputException("Airplane with id: " + airplaneId + " does not exist");
        }
    }

    @Override
    public Airplane moveAirplaneToCompany(long airplaneId, long companyId) {
        AirCompany airCompany = airCompanyService.findAirCompanyById(companyId);
        Airplane airplane = findAirplaneById(airplaneId);
        airplane.setAirCompany(airCompany);
        return airplane;
    }
}
