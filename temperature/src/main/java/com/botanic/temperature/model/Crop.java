package com.botanic.temperature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Crop {
    private String name;
    private String description;
    private Float minTemp;
    private Float maxTemp;

    Integer id;

    public Crop(String name, String description, Float minTemp, Float maxTemp) {
        this.name = name;
        this.description = description;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
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

    @Override
    public String toString() {
        return "Crop{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", id=" + id +
                '}';
    }
}
