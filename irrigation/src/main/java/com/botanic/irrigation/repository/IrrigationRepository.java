package com.botanic.irrigation.repository;

import com.botanic.irrigation.model.Irrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigationRepository extends JpaRepository<Irrigation, Integer> {

}
