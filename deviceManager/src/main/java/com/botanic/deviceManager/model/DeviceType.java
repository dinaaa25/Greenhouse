package com.botanic.deviceManager.model;

import jakarta.persistence.*;

@Entity
@Table
public class DeviceType {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public DeviceType(String name, Integer id) {
        this.name = name;
        this.id = id;
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
}
