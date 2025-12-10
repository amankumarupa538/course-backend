package com.pragyan.service;


import com.pragyan.Dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String WEATHER_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=8380aa988f5b8d4bd37c4b9bd20232b6";

    public WeatherResponse getWeather() {
        return restTemplate.getForObject(WEATHER_URL, WeatherResponse.class);
    }
}

