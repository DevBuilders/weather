package com.kroger.weather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @RequestMapping(path = "/weather")
    public String getWeather() {
        return "It is sunny today";
    }
}
