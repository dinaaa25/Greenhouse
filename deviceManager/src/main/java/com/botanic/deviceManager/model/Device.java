package com.botanic.deviceManager.model;

import jakarta.persistence.*;

enum DeviceStatusType {
    PERCENTAGE,
    SWITCH
}

@Entity
@Table
public class Device {
    private String name;

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private DeviceType type;

    @Enumerated
    private DeviceStatusType status;

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeviceStatusType getStatus() {
        return status;
    }

    public void setStatus(DeviceStatusType status) {
        this.status = status;
    }
}
