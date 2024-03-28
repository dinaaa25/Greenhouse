package com.botanic.greenhouse.controller;

import com.botanic.greenhouse.model.Area;
import com.botanic.greenhouse.model.Crop;
import com.botanic.greenhouse.repository.CropRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/crop")
public class CropController {

    @Autowired
    private CropRepository cropRepository;

    @GetMapping("/{id}")
    public Crop getCrop(@PathVariable("id") Integer id) {
        Crop crop = cropRepository.findById(id).orElse(null);
        if (crop == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not find your crop");
        }
        return crop;
    }

    @GetMapping()
    public List<Crop> getCrops() {
        return cropRepository.findAll();
    }


    @PostMapping()
    public Crop addCrop(Crop crop) {
        return cropRepository.saveAndFlush(crop);
    }

    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable("id") int id) {
        cropRepository.deleteById(id);
    }
}
