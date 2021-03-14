package com.fly.management.service.serviceImpl;

import com.fly.management.exceptions.UserWrongInputException;
import com.fly.management.model.AirCompany;
import com.fly.management.repository.AirCompanyRepository;
import com.fly.management.service.AirCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    @Autowired
    private AirCompanyRepository airCompanyRepository;

    @Override
    public AirCompany saveAirCompany(AirCompany airCompany) {
        AirCompany newAirCompany = airCompanyRepository.save(airCompany);
        return newAirCompany;
    }

    @Override
    public void deleteAirCompanyById(Long id) {
        try {
            airCompanyRepository.deleteById(id);
        } catch (Exception e) {
            throw new UserWrongInputException("Air company with id: " + id + " does not exist");
        }
    }

    @Override
    public List<AirCompany> findAll() {
        List<AirCompany> airCompanyList = airCompanyRepository.findAll();
        return airCompanyList;
    }

    @Override
    public AirCompany findAirCompanyById(Long id) {
        Optional<AirCompany> airCompany = airCompanyRepository.findById(id);
        if (airCompany.isPresent()) {
            return airCompany.get();
        } else {
            throw new UserWrongInputException("Company with id: " + id + "does not exist");
        }
    }
}
