package com.example.services;


import com.example.dto.ResponseDto;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vinit on 3/30/17.
 */

@Component
public class FREDServiceClientService {

    private final String FREDUrl = "https://api.stlouisfed.org/fred/series/observations?&aggregation_method=<aggregation_method>&series_id=<series_id>&frequency=<frequency>&api_key=11a67fcf7e103c988b6fa755ee44000f&file_type=json";


    private RestOperations restTemplate;


    public FREDServiceClientService(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FREDServiceClientService() {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }


    public ResponseDto retrieveFREDDataSeries(String series_id, String aggregationMethod, String frequency) {

        ResponseDto responseDto;
        String url = FREDUrl.replace("<series_id>", series_id).replace("<aggregation_method>", aggregationMethod).replace("<frequency>", frequency);
        System.out.println(url);
        responseDto = new RestTemplate().getForObject(FREDUrl.replace("<series_id>", series_id).replace("<aggregation_method>", aggregationMethod).replace("<frequency>", frequency), ResponseDto.class);


        return responseDto;
    }

}
