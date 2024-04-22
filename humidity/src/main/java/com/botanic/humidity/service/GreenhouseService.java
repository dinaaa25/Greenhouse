package com.botanic.humidity.service;

import com.botanic.temperature.model.Crop;
import com.botanic.temperature.model.TempRange;
import com.botanic.temperature.model.TemperatureMeasurement;
import com.botanic.temperature.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.Sort;

import java.util.*;

@Service
public class GreenhouseService {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private HumidityRepository humidityRepository;

  @Value("${queue.result}")
  private String queueId;

  protected List<Crop> getCropList(Integer greenHouseId) {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Crop[]> response = restTemplate
        .getForEntity("http://greenhouse:8080/greenhouse/{greenHouseId}/crops", Crop[].class, greenHouseId);
    if (response.getBody() == null) {
      return new ArrayList();
    }
    return Arrays.asList(response.getBody());
  }

  protected List<Integer> getAllGreenhouseIds() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Integer[]> response = restTemplate.getForEntity("http://greenhouse:8080/greenhouse/ids",
        Integer[].class);
    if (response.getBody() == null) {
      return new ArrayList();
    }
    return Arrays.asList(response.getBody());
  }

  public TempRange getBestTemperature(Integer greenHouseId) {
    List<Crop> cropList = getCropList(greenHouseId);
    if (cropList.size() == 0) {
      TemperatureMeasurement currentTemp = getCurrentTemp(greenHouseId);
      return new TempRange(currentTemp.getInsideTemp(), currentTemp.getInsideTemp()); // TODO return the current temp of
                                                                                      // the greenhouse then to keep it
                                                                                      // the same
    }
    Float currentMinTemp = cropList.get(0).getMinTemp();
    Float currentMaxTemp = cropList.get(0).getMaxTemp();
    for (int i = 0; i < cropList.size(); i++) {
      Float minTemp = cropList.get(i).getMinTemp();
      Float maxTemp = cropList.get(i).getMaxTemp();
      if (minTemp > currentMinTemp) {
        currentMinTemp = minTemp;
      }
      if (maxTemp < currentMaxTemp) {
        currentMaxTemp = maxTemp;
      }
    }
    // TODO finish implementation
    return new TempRange(currentMinTemp, currentMaxTemp);
  }

  @Scheduled(fixedRate = 600000) // 600000 milliseconds = 10 minutes
  public void updateBestTemperatureQueue() {
    List<Integer> allGreenhouseIds = this.getAllGreenhouseIds();
    for (int index = 0; index < allGreenhouseIds.size(); index++) {
      TempRange tempRange = getBestTemperature(allGreenhouseIds.get(index));
      jmsTemplate.convertAndSend(queueId, tempRange);
    }
  }

  @JmsListener(destination = "temperature_measurment")
  public void receiveTemperatureMeasurement(TemperatureMeasurement temperatureMeasurement) {
    System.out.println("jello");
    temperatureRepository.saveAndFlush(temperatureMeasurement);
  }

  public TemperatureMeasurement getCurrentTemp(Integer greenhouseID) {
    TemperatureMeasurement currentTempMeasure = getAllTempSortedByDate(greenhouseID).get(0);
    return currentTempMeasure;
  }

  public List<TemperatureMeasurement> getAllTempSortedByDate(Integer greenhouseID) {
    TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement();
    temperatureMeasurement.setGreenhouseId(greenhouseID);
    Sort sort = Sort.by(Sort.Direction.DESC, "measuredDateTime"); // Replace "date" with your actual date field name
    List<TemperatureMeasurement> temperature = temperatureRepository.findBy(Example.of(temperatureMeasurement),
        fetchableFluentQuery -> fetchableFluentQuery.sortBy(sort).all());
    return temperature;
  }

}
