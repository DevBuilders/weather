package com.kroger.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    private RestTemplate restTemplate;

    @Value("${weather.api-key}")
    private String weatherApiKey;

    @Autowired
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getWeather() {
        HashMap map = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=Cincinnati&appid=" + weatherApiKey, HashMap.class);
        List<Map> weather = (List<Map>)map.get("weather");
        return weather.get(0).get("main").toString();
    }
}
