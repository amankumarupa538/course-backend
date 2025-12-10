package com.pragyan.Dto;

import java.sql.Timestamp;
import java.util.List;

public class WeatherResponse {
     Coordinate coord;
     List<Weather> weather;
     String base;
     MainDetails main;
     int visibility;
     Wind wind;
     Cloud clouds;
     Timestamp dt;
     Systm sys;
     int timezone;
     int id;
     String name;
     int cod;

}
