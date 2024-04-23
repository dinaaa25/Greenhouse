package com.botanic.humidity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.botanic.humidity.model.HumidityMeasurement;

@Repository
public abstract class HumidityRepository implements JpaRepository<HumidityMeasurement, Integer> {

}
