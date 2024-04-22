package com.botanic.humidity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class HumidityMeasurement {

  @Id
  @GeneratedValue
  private Integer id;

  private Integer greenhouseId;

  private Float humidity;

  private Date measuredDateTime;

  public Date getMeasuredDateTime() {
    return measuredDateTime;
  }

  public void setMeasuredDateTime(Date measuredDateTime) {
    this.measuredDateTime = measuredDateTime;
  }

  public Float getHumidity() {
    return humidity;
  }

  public void setHumidity(Float humidity) {
    this.humidity = humidity;
  }

  public void setGreenhouseId(Integer id) {
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
