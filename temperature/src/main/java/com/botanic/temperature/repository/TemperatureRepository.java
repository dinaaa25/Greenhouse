package com.botanic.temperature.repository;

import com.botanic.temperature.model.TemperatureMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureMeasurement, Integer>{

}