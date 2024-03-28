package com.botanic.greenhouse.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Greenhouse {
    private String name;
    private String description;

    @OneToMany(mappedBy = "greenhouse", cascade = {CascadeType.REMOVE})
    List<Area> areas;

    @Id
    @GeneratedValue
    final int id;

    public Greenhouse() {
        id = -1;
    }


    public Greenhouse(String name, String description, int id, List<Area> areas) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.areas = areas;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public List<Area> getAreas() {
        return this.areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

//    public List<Crop> getAllGreenhouseCrops(){
//        return areas.stream().map(a -> a.getCrop()).toList();
//    }


}
