package com.botanic.temperature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class TemperatureMeasurement {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer greenhouseId;

    private Float insideTemp;

    private Float outsideTemp;

    private Date measuredDateTime;

    public Date getMeasuredDateTime() {
        return measuredDateTime;
    }

    public void setMeasuredDateTime(Date measuredDateTime) {
        this.measuredDateTime = measuredDateTime;
    }

    public Float getInsideTemp() {
        return insideTemp;
    }

    public void setInsideTemp(Float insideTemp) {
        this.insideTemp = insideTemp;
    }

    public Float getOutsideTemp() {
        return outsideTemp;
    }

    public void setOutsideTemp(Float outsideTemp) {
        this.outsideTemp = outsideTemp;
    }

    public void setGreenhouseId(Integer id){
        this.greenhouseId = id;
    }

    public Integer getGreenhouseId() {
        return greenhouseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
