package com.botanic.humidity.service;

import com.botanic.humidity.model.HumidityMeasurement;
import com.botanic.humidity.repository.HumidityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseService {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private HumidityRepository humidityRepository;

  @Value("${queue.result}")
  private String queueId;

  @JmsListener(destination = "humidity_measurement")
  public void receiveTemperatureMeasurement(HumidityMeasurement hMeasurement) {
    humidityRepository.saveAndFlush(hMeasurement);
  }
}
