package com.botanic.irrigation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Range {

    Float min;
    Float max;
    String unit;

    @Id
    @GeneratedValue
    Integer id;

    public Range(Float min, Float max) {
        this.min = min;
        this.max= max;
    }

    public Range() {

    }

    public boolean contains(Float value) {
        return this.min <= value && this.max >= value;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
