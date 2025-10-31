package com.pragyan.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
public class LocationController {
    private static final Map<String,List<String>> STATE_CITY = Map.of(
            "Maharashtra", List.of("Mumbai","Pune","Nagpur"),
            "Gujarat", List.of("Ahmedabad","Surat","Vadodara"),
            "Karnataka", List.of("Bangalore","Mysore","Mangalore"),
            "Delhi", List.of("New Delhi","Rohini","Dwarka")
    );
    @GetMapping("/states") public List<String> states(){ return new ArrayList<>(STATE_CITY.keySet()); }
    @GetMapping("/cities/{state}") public List<String> cities(@PathVariable String state){ return STATE_CITY.getOrDefault(state, List.of()); }
}
