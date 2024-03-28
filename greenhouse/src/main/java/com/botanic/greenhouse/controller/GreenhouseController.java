package com.botanic.greenhouse.controller;

import com.botanic.greenhouse.model.Greenhouse;
import com.botanic.greenhouse.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greenhouse")
public class GreenhouseController {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @GetMapping()
    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Greenhouse getGreenhouseByID(@PathVariable("id") int id) {
        return greenhouseRepository.getReferenceById(id);
    }

    @PostMapping()
    public Greenhouse addGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.saveAndFlush(greenhouse);
    }

    @DeleteMapping("/{id}")
    public void deleteGreenhouse(@PathVariable("id") int id) {
        greenhouseRepository.deleteById(id);
    }

    @PutMapping()
    public Greenhouse modifyGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.saveAndFlush(greenhouse);
    }
}
