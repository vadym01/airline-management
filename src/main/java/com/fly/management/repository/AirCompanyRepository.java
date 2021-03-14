package com.fly.management.repository;

import com.fly.management.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    Optional<AirCompany> findByName(String name);
}
