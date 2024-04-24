package com.botanic.deviceManager.repository;

import com.botanic.deviceManager.model.Device;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
