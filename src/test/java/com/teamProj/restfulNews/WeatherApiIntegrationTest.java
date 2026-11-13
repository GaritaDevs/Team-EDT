package com.teamProj.restfulNews;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.util.PropertiesLoader;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class WeatherApiIntegrationTest implements PropertiesLoader {

    @Test
    void testGetCurrentWeather() throws Exception {

        // Load API properties
        Properties properties =
                loadProperties("/weatherapi.properties");

        String apiKey = properties.getProperty("key");
        String apiUrl = properties.getProperty("url.currentWeather");

        assertNotNull(apiKey);
        assertFalse(apiKey.isEmpty());

        assertNotNull(apiUrl);
        assertFalse(apiUrl.isEmpty());

        // Specify the location
        String location = URLEncoder.encode(
                "Madison",
                StandardCharsets.UTF_8
        );

        // Build API request
        String requestUrl =
                apiUrl + apiKey + "&q=" + location + "&aqi=no";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();

        // Send request
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        // Verify API response
        assertEquals(200, response.statusCode(),
                "WeatherAPI should return HTTP 200");

        // Convert JSON into Java object
        ObjectMapper mapper = new ObjectMapper();

        CurrentWeather weather = mapper.readValue(
                response.body(),
                CurrentWeather.class
        );

        // Verify location information
        assertNotNull(weather.getLocation());
        assertEquals("Madison", weather.getLocation().getName());

        // Verify current weather information
        assertNotNull(weather.getCurrent());
        assertNotNull(weather.getCurrent().getTempF());
        assertNotNull(weather.getCurrent().getTempC());
        assertNotNull(weather.getCurrent().getHumidity());

        // Verify weather condition
        assertNotNull(weather.getCurrent().getCondition());
        assertNotNull(weather.getCurrent().getCondition().getText());
    }
}