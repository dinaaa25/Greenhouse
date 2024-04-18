package com.botanic.irrigation.service;

import com.botanic.irrigation.model.Crop;
import com.botanic.irrigation.model.Irrigation;
import com.botanic.irrigation.model.Range;
import com.botanic.irrigation.model.TemperatureMeasurement;
import com.botanic.irrigation.repository.IrrigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class GreenhouseService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private IrrigationRepository irrigationRepository;

    public List<Irrigation> getCropIrrigationInfo(Integer cropId){
        Irrigation irrigation = new Irrigation();
        irrigation.setCropId(cropId);
        List<Irrigation> irrigationCrop = irrigationRepository.findBy(Example.of(irrigation), fetchableFluentQuery -> fetchableFluentQuery.all());
        return irrigationCrop;
    }

    @Scheduled(fixedDelay = 15, timeUnit = TimeUnit.MINUTES)
    public void setIrrigations() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("http://localhost:8080/")
    }

    public Irrigation getCropIrrigationByTemp(Integer greenhouseId, Integer cropId) {
        Range tempRange = getTempMinMaxOfCrop(cropId);
        Float currentGreenhouseTemp = getGreenhouseInsideTemp(greenhouseId, cropId);
        Irrigation irrigation = new Irrigation();
        irrigation.setCropId(cropId);

        Optional<Irrigation> theIrrigation = irrigationRepository.findBy(Example.of(irrigation), fetchableFluentQuery -> fetchableFluentQuery.stream().filter(irrigation1 -> irrigation1.getTempRange().contains(currentGreenhouseTemp)).findFirst());

        return theIrrigation.orElse(null);
    }



    public Float getGreenhouseInsideTemp(Integer greenhouseId, Integer cropId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TemperatureMeasurement> response = restTemplate.getForEntity("http://localhost:8081/temperature/{greenhouseId}", TemperatureMeasurement.class, greenhouseId);
        return response.getBody().getInsideTemp();
    }

    public Range getTempMinMaxOfCrop(Integer cropId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Crop> response = restTemplate.getForEntity("http://localhost:8080/greenhouse/crop/{cropId}", Crop.class, cropId);
        Float minTemp = response.getBody().getMaxTemp();
        Float maxTemp = response.getBody().getMinTemp();
        Range tempRange = new Range(minTemp, maxTemp);
        return tempRange;
    }


}
