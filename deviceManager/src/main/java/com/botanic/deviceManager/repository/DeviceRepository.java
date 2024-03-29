package com.botanic.deviceManager.repository;

import com.botanic.deviceManager.model.Device;
import com.botanic.deviceManager.model.DeviceStatus;
import com.botanic.deviceManager.model.DeviceType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class DeviceRepository {

    public List<Device> getAllDevices() {
        return List.of(new Device("Mark's Device", 1, DeviceType.FAN, new DeviceStatus(DeviceStatus.Operator.ONOFF, "ON")));
    }


    public Device getDeviceById(Integer id) {
        return new Device("Dina's Device", 2, DeviceType.HEATER, new DeviceStatus(DeviceStatus.Operator.ONOFF, "OFF"));
    }

    public Device addNewDevice(Device newDevice) {
        return new Device("Paul's Device", 3, DeviceType.LIGHT, new DeviceStatus(DeviceStatus.Operator.ONOFF, "ON"));
    }

    public void deleteDeviceById(Integer deviceId){

    }

    public void saveDeviceinDB(Device receivedDevice){

    }

}
