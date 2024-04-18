package com.botanic.irrigation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

public class Crop {
    private String name;
    private String description;
    private Float minTemp;
    private Float maxTemp;

    Integer id;

    Area area;

    public Crop() {}

    public Crop(String name, String description, int id, Float minTemp, Float maxTemp) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMinTemp() {
        return this.minTemp;
    }

    public Float getMaxTemp() {
        return this.maxTemp;
    }

    public Float setMaxTemp(Float maxTemp) {
        return this.maxTemp = maxTemp;
    }

    public Float setMinTemp(Float minTemp) {
        return this.minTemp = minTemp;
    }
}
