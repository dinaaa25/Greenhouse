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

    @Autowired
    DeviceService deviceService;

    @GetMapping()
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable("id") Integer deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow();
    }

    // todo option when the greenhouse computer connects the new device it is
    // automatically registered in activemq and read from the device service and
    // passed into the database
    @PostMapping()
    public Device addNewDevice(Device device) {
        deviceService.addDevice(device);
        return device;
    }

    @DeleteMapping("/{id}")
    public void deleteDeviceById(@PathVariable("id") Integer deviceId) {
        deviceRepository.deleteById(deviceId);
    }

}
