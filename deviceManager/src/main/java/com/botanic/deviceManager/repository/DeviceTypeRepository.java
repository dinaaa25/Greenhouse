package com.botanic.deviceManager.repository;

import com.botanic.deviceManager.model.DeviceType;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {

}
