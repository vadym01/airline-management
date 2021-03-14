package com.fly.management.service;

import com.fly.management.model.Airplane;


public interface AirplaneService {

    Airplane saveAirplane(Airplane airplane);

    Airplane moveAirplaneToCompany(long airplaneId, long companyId);

    Airplane findAirplaneById(long airplaneId);
}
