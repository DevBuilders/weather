package com.kroger.weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(WeatherService.class)
public class WeatherServiceTest {
    private String weatherJson;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private MockRestServiceServer server;

    @Value("${weather.api-key}")
    private String weatherApiKey;

    @Before
    public void loadWeatherJson() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("weather.json").toURI());
        weatherJson = new String(Files.readAllBytes(path));
    }

    @Test
    public void testGetWeather() {
        String expectedUri = "http://api.openweathermap.org/data/2.5/weather?q=Cincinnati&appid=" + weatherApiKey;
        this.server.expect(requestTo(expectedUri)).andRespond(withSuccess(weatherJson, MediaType.APPLICATION_JSON));
        assertEquals(weatherService.getWeather(), "Mist");
    }

}
