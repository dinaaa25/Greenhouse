package com.botanic.temperature.model;

public class Crop {
    private String name;
    private String description;
    private Float minTemp;
    private Float maxTemp;
    final Integer id;

    public Crop() {
        id = -1;
    }

    public Crop(String name, String description, int id, Float minTemp, Float maxTemp) {
        this.name = name;
        this.description = description;
        this.id = id;
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
