package com.pragyan.controller;

import com.pragyan.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nasa")
public class NasaController {

    @Autowired
    NasaService nasaService;

    @GetMapping
    public String getData() {
        return nasaService.getNasaData();
    }
}


