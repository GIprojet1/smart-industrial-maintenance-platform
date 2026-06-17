package com.example.demo.service;

import com.example.demo.dto.DataRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CentralSystemService {

    private final RestTemplate restTemplate;
    private final DataService dataService;

    public CentralSystemService(
            RestTemplate restTemplate,
            DataService dataService
    ) {
        this.restTemplate = restTemplate;
        this.dataService = dataService;
    }

    public void synchronizeData() {

        String apiUrl =
                "http://localhost:9000/api/live-data";

        DataRequest request =
                restTemplate.getForObject(
                        apiUrl,
                        DataRequest.class
                );

        if(request != null){

            dataService.saveDataFromDto(
                    request
            );
        }
    }
}