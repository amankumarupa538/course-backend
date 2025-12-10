package com.pragyan.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
    public class NasaService {

        private final RestTemplate restTemplate = new RestTemplate();
        private final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=jrAFstWuuDWVI2qMqh5J1bXaQUpoejQK47IYFBdH";

        public String getNasaData() {
            return restTemplate.getForObject(NASA_URL, String.class);
        }
    }


