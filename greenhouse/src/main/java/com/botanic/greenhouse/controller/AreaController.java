package com.botanic.greenhouse.controller;

import com.botanic.greenhouse.model.Area;
import com.botanic.greenhouse.model.Crop;
import com.botanic.greenhouse.model.Polygon;
import com.botanic.greenhouse.repository.AreaRepository;
import com.botanic.greenhouse.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaRepository areaRepository;

    @PostMapping()
    public void addArea(Area area) {
        areaRepository.saveAndFlush(area);
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable("id") int id) {
        areaRepository.deleteById(id);
    }

}
