package com.botanic.deviceManager.model;

public class DeviceStatus {
    Operator operatorType;
    String status;

    public enum Operator{
        ONOFF,
        Percentage
    }

    public DeviceStatus(Operator operatorType, String status) {
        this.operatorType = operatorType;
        this.status = status;
    }
}
