package com.botanic.deviceManager.controller;

import com.botanic.deviceManager.model.DeviceType;
import com.botanic.deviceManager.repository.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device-type")
public class DeviceTypeController {

  @Autowired
  DeviceTypeRepository repository;

  @GetMapping()
  public List<DeviceType> getAll() {
    return repository.findAll();
  }

}
