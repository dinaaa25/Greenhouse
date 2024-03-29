package com.botanic.temperature.service;

import com.botanic.temperature.model.Crop;
import com.botanic.temperature.model.TempRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GreenhouseService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${queue.result}")
    private String queueId;

    protected List<Crop> getCropList(Integer greenHouseId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Crop[]> response = restTemplate.getForEntity("http://localhost:8080/greenhouse/{greenHouseId}/crops", Crop[].class, greenHouseId);
        if(response.getBody() == null) {
            return new ArrayList();
        }
        return Arrays.asList(response.getBody());
    }

    protected List<Integer> getAllGreenhouseIds() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer[]> response = restTemplate.getForEntity("http://localhost:8080/greenhouse/ids", Integer[].class);
        if(response.getBody() == null) {
            return new ArrayList();
        }
        return Arrays.asList(response.getBody());
    }

    public TempRange getBestTemperature(Integer greenHouseId) {
        List<Crop> cropList = getCropList(greenHouseId);
        if(cropList.size() == 0) {
            return new TempRange(0F, 100F); // TODO return the current temp of the greenhouse then to keep it the same
        }
        Float currentMinTemp = cropList.get(0).getMinTemp();
        Float currentMaxTemp = cropList.get(0).getMaxTemp();
        for (int i=0; i < cropList.size(); i++) {
            Float minTemp = cropList.get(i).getMinTemp();
            Float maxTemp = cropList.get(i).getMaxTemp();
            if (minTemp > currentMinTemp) {
                currentMinTemp = minTemp;
            }
            if (maxTemp < currentMaxTemp) {
                currentMaxTemp = maxTemp;
            }
        }
        //TODO finish implementation
        return new TempRange(currentMinTemp, currentMaxTemp);
    }

    @Scheduled(fixedRate = 600000) // 600000 milliseconds = 10 minutes
    public void updateBestTemperatureQueue() {
        List<Integer> allGreenhouseIds = this.getAllGreenhouseIds();
        for(int index = 0; index < allGreenhouseIds.size(); index++) {
            TempRange tempRange = getBestTemperature(allGreenhouseIds.get(index));
            jmsTemplate.convertAndSend(queueId, tempRange);
        }
    }

}
