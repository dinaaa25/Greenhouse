package com.botanic.greenhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table
public class Area {

    @ManyToOne
    @JsonBackReference
    private Greenhouse greenhouse;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Polygon polygon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Crop crop;

    @Id
    @GeneratedValue
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
