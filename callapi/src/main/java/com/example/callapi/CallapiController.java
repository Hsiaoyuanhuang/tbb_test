package com.example.callapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallapiController {

    public static void main(String[] args) {
        SpringApplication.run(CallapiApplication.class, args);
    }

    @GetMapping("/opendata")
    public String getOpenData() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://od.moi.gov.tw/api/v1/rest/datastore/301000000A-002073-001";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }

}
