package com.botanic.irrigation.model;


import jakarta.persistence.*;

@Entity
@Table
public class Irrigation {

    @OneToOne()
    private Range tempRange;

    @Id
    @GeneratedValue
    Integer id;

    private Integer cropId;
    private IrrigationLevel irrigationLevel;
    private String description;

    @OneToOne()
    private Range weeklyWatering;

    @OneToOne()
    private Range waterAmount;


    public Irrigation(Range tempRange, Integer cropId, IrrigationLevel irrigationLevel, String description, Range weeklyWatering, Range waterAmount) {
        this.tempRange = tempRange;
        this.irrigationLevel = irrigationLevel;
        this.description = description;
        this.weeklyWatering = weeklyWatering;
        this.waterAmount = waterAmount;
        this.cropId = cropId;
    }

    public Irrigation() {

    }

    public enum IrrigationLevel{
        LOW,
        MODERATE,
        HIGH
    }

    public Range getTempRange() {
        return this.tempRange;
    }

    public void setTempRange(Range tempRange) {
        this.tempRange = tempRange;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getCropId() {
        return this.cropId;
    }

    public IrrigationLevel getIrrigationLevel() {
        return this.irrigationLevel;
    }

    public void setIrrigationLevel(IrrigationLevel irrigationLevel) {
        this.irrigationLevel = irrigationLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Range getWeeklyWatering() {
        return weeklyWatering;
    }

    public void setWeeklyWatering(Range weeklyWatering) {
        this.weeklyWatering = weeklyWatering;
    }

    public Range getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Range waterAmount) {
        this.waterAmount = waterAmount;
    }


}
