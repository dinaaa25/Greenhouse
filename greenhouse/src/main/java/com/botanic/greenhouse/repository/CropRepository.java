package com.botanic.greenhouse.repository;

import com.botanic.greenhouse.model.Crop;
import com.botanic.greenhouse.model.Greenhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer> {

}
