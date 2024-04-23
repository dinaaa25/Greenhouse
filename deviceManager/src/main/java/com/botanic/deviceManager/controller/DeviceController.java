package com.botanic.deviceManager.controller;

import com.botanic.deviceManager.model.Device;
import com.botanic.deviceManager.repository.DeviceRepository;
import com.botanic.deviceManager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping()
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable("id") Integer deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteDeviceById(@PathVariable("id") Integer deviceId) {
        deviceRepository.deleteById(deviceId);
    }

}
