package com.pragyan.controller;


import com.pragyan.Dto.WeatherResponse;
import com.pragyan.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    @Autowired
    WeatherService service;

    @GetMapping("/get")
    public WeatherResponse getWeather() {
        return service.getWeather();
    }
}

