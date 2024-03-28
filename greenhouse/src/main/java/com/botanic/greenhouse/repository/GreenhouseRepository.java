package com.botanic.greenhouse.repository;

import com.botanic.greenhouse.model.Greenhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// here we define the CRUD operations
//JPARepository is an interface to do the Crud Operations
@Repository
public interface GreenhouseRepository extends JpaRepository<Greenhouse, Integer> {

}
