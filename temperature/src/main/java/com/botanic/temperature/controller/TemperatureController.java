package com.botanic.temperature.controller;

import com.botanic.temperature.model.TempRange;
import com.botanic.temperature.model.TemperatureMeasurement;
import com.botanic.temperature.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    GreenhouseService greenhouseService;


    // returns the current Temperature in the greenhouse
    @GetMapping("/{id}/current")
    public TemperatureMeasurement getInsideTemp(@PathVariable("id") int greenhouseID) {
        return new TemperatureMeasurement();
    }


    // get the best temperature for the current crops in the greenhouse with id
    @GetMapping("/{id}/best")
    public TempRange getBestTemp(@PathVariable("id") int greenhouseID) {
        return greenhouseService.getBestTemperature(greenhouseID);
    }

}
