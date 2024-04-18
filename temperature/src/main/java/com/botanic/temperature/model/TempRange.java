package com.botanic.temperature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class TempRange {
    Float minTemp;
    Float maxTemp;

    Integer id;

    public TempRange(Float minTemp, Float maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Float minTemp) {
        this.minTemp = minTemp;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Float maxTemp) {
        this.maxTemp = maxTemp;
    }
}
