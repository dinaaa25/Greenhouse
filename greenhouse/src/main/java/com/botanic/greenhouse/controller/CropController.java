package com.botanic.greenhouse.controller;

import com.botanic.greenhouse.model.Area;
import com.botanic.greenhouse.model.Crop;
import com.botanic.greenhouse.repository.CropRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    // get all crops from all greenhouses registered in this system
    @GetMapping()
    public List<Crop> getCrops() {
        return cropRepository.findAll();
    }

    @PutMapping()
    public Crop updateCrop(Crop crop) {
        Crop existingCrop = cropRepository.findById(crop.getId())
                .orElseThrow(() -> new HttpStatusCodeException(HttpStatus.NOT_FOUND, "Crop not found with id: " + crop.getId()) {
                });

        // Update the existing crop entity with new details
        existingCrop.setName(crop.getName() != null ? crop.getName() : existingCrop.getName());
        existingCrop.setMaxTemp(crop.getMaxTemp() != null ? crop.getMaxTemp() : existingCrop.getMaxTemp());
        existingCrop.setMinTemp(crop.getMinTemp() != null ? crop.getMinTemp() : existingCrop.getMinTemp());
        existingCrop.setDescription(crop.getDescription() != null ? crop.getDescription() : existingCrop.getDescription());

        // Save the updated crop entity
        return cropRepository.saveAndFlush(existingCrop);
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
