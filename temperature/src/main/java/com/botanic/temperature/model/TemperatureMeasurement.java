package com.botanic.temperature.model;

import java.util.Date;


public class TemperatureMeasurement {

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

}
