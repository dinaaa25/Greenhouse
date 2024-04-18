package com.botanic.temperature.controller;

import com.botanic.temperature.model.TempRange;
import com.botanic.temperature.model.TemperatureMeasurement;
import com.botanic.temperature.repository.TemperatureRepository;
import com.botanic.temperature.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/temperature")
public class TemperatureController {

    @Autowired
    GreenhouseService greenhouseService;

    @Autowired
    TemperatureRepository temperatureRepository;


    // returns the current Temperature in the greenhouse
    @GetMapping("/{id}/current")
    public Float getInsideTemp(@PathVariable("id") int greenhouseID) {
        return greenhouseService.getCurrentTemp(greenhouseID).getInsideTemp();
    }


    // get the best temperature for the current crops in the greenhouse with id
    @GetMapping("/{id}/best")
    public TempRange getBestTemp(@PathVariable("id") int greenhouseID) {
        return greenhouseService.getBestTemperature(greenhouseID);
    }

    @GetMapping("/{id}/history")
    public List<TemperatureMeasurement> getTemperatureHistory(@PathVariable("id") Integer greenhouseID) {
        return greenhouseService.getAllTempSortedByDate(greenhouseID);
    }



}
