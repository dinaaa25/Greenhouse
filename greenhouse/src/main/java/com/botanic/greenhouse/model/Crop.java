package com.botanic.greenhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Crop {
    private String name;
    private String description;
    private Float minTemp;
    private Float maxTemp;
    private String image;


    @Id
    @GeneratedValue
    Integer id;

    @OneToMany()
    @JsonBackReference
    List<Area> area;

    public Crop() {}

    public Crop(String name, String description, int id, Float minTemp, Float maxTemp) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public List<Area> getArea() {
        return area;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    public String getImage() { return this.image; }

    public void setImage(String image) {this.image = image;}

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
