package com.botanic.irrigation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

public class Area {

    @JsonBackReference
    private Greenhouse greenhouse;

    @JsonManagedReference
    private Polygon polygon;

    @JsonManagedReference
    private Crop crop;

    private Integer id;

    public Area(Crop crop, Polygon polygon) {
        this.crop = crop;
        this.polygon = polygon;
    }

    public Area() {}

    public Greenhouse getGreenhouse() {
        return this.greenhouse;
    }

    public void setGreenhouse(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }

    public Crop getCrop() {
        return this.crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public int getId() {
        return this.id;
    }
}
