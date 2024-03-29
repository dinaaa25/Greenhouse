package com.botanic.temperature.model;

public class TempRange {
    Float minTemp;
    Float maxTemp;

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
