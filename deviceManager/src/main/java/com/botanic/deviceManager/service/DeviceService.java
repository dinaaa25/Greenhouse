package com.botanic.deviceManager.service;

import com.botanic.deviceManager.model.Device;
import com.botanic.deviceManager.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${queue.result}")
    private String queue;

    private String result = "device_result";

    public void addDevice(Device device) {
        jmsTemplate.convertAndSend(queue, device);
    }

    @JmsListener(destination = "${queue.result}")
    public void receiveDeviceRegistration(Device receivedDevice) {
        deviceRepository.saveAndFlush(receivedDevice);
    }

}
