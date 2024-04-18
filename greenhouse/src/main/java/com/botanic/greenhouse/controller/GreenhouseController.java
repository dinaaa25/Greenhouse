package com.botanic.greenhouse.controller;

import com.botanic.greenhouse.model.Crop;
import com.botanic.greenhouse.model.Greenhouse;
import com.botanic.greenhouse.repository.CropRepository;
import com.botanic.greenhouse.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/greenhouse")
public class GreenhouseController {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Autowired
    private CropRepository cropRepository;

    @GetMapping()
    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    @GetMapping("/ids")
    public List<Integer> getAllGreenhouseIds() {
        return greenhouseRepository.findAll().stream().map(e -> e.getId()).toList();
    }

    @GetMapping("/{id}")
    public Greenhouse getGreenhouseByID(@PathVariable("id") int id) {
        return greenhouseRepository.findById(id).orElse(null);
    }

    // get all crops of one greenhouse with id
    @GetMapping("/{id}/crops")
    public List<Crop> getCrops(@PathVariable("id") int id) {
        return greenhouseRepository.findById(id).orElse(null).getAllGreenhouseCrops();
    }

    @PostMapping()
    public Greenhouse addGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.saveAndFlush(greenhouse);
    }

    @DeleteMapping("/{id}")
    public void deleteGreenhouse(@PathVariable("id") int id) {
        greenhouseRepository.deleteById(id);
    }

    @PostMapping("/{greenhouseId}/{cropId}")
    public void addCropToGreenhouse(@PathVariable("greenhouseId") int greenhouseId, @PathVariable("cropId") int cropId) {
        Greenhouse greenhouse = greenhouseRepository.findById(greenhouseId).orElse(null);
        System.out.println(greenhouse);
        Crop crop = cropRepository.findById(cropId).orElse(null);
        System.out.println(crop);
        if (crop != null) {
            greenhouse.addNewCrop(crop);
        }
        System.out.println(greenhouse);
        greenhouseRepository.saveAndFlush(greenhouse);
    }

    @PutMapping()
    public Greenhouse modifyGreenhouse(Greenhouse greenhouse) {
        Greenhouse existingGreenhouse = greenhouseRepository.findById(greenhouse.getId())
                .orElseThrow(() -> new HttpStatusCodeException(HttpStatus.NOT_FOUND, "Greenhouse not found with id: " + greenhouse.getId()) {
                });
        existingGreenhouse.setName(greenhouse.getName() != null ? greenhouse.getName() : existingGreenhouse.getName());
        existingGreenhouse.setDescription(greenhouse.getDescription() != null ? greenhouse.getDescription() : existingGreenhouse.getDescription());
        existingGreenhouse.setAreas(greenhouse.getAreas() != null ? greenhouse.getAreas() : existingGreenhouse.getAreas());

        return greenhouseRepository.saveAndFlush(greenhouse);
    }
}
