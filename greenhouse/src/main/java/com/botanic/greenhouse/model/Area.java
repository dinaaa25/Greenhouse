package com.botanic.greenhouse.model;

import jakarta.persistence.*;

@Entity
@Table
public class Area {

    @ManyToOne
    private Greenhouse greenhouse;

    @OneToOne
    private Polygon polygon;

    @ManyToOne()
    private Crop crop;

    @Id
    @GeneratedValue
    private Integer id;

    public Area(Crop crop, Polygon polygon) {
        this.crop = crop;
        this.polygon = polygon;
    }

    public Area() {

    }

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
