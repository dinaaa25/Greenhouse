package com.botanic.deviceManager.model;

public class Device {

    private String name;
    private Integer id;
    private DeviceType type;
    private DeviceStatus status;

    public Device(String name, Integer id, DeviceType type, DeviceStatus status) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.status = status;
    }

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

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }
}
