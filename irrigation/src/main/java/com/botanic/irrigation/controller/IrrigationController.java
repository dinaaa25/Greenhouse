package com.botanic.irrigation.controller;

import com.botanic.irrigation.model.Irrigation;
import com.botanic.irrigation.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/irrigation")
public class IrrigationController {

    @Autowired
    GreenhouseService greenhouseService;

    @GetMapping("/{id}")
    public List<Irrigation> getCropIrrigationInfo(@PathVariable("id") Integer cropId) {
        return greenhouseService.getCropIrrigationInfo(cropId);
    }

    @GetMapping("/{greenhouseId}/{id}")
    public Irrigation getCropIrrigationInfoForCurrentTemp(@PathVariable("id") Integer greenhouseId, @PathVariable("id") Integer cropId) {
        return greenhouseService.getCropIrrigationByTemp(greenhouseId, cropId);
    }

}
