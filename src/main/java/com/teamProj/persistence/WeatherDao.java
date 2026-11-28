package com.teamProj.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

/**
 * The type Weather dao.
 */
public class WeatherDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;
    private String weatherApiKey;
    private String weatherApiUrl;

    /**
     * Instantiates a new Weather dao.
     */
    public WeatherDao() {
        try {
            properties = loadProperties("/weatherapi.properties");
            weatherApiKey = properties.getProperty("key");
            weatherApiUrl = properties.getProperty("url.currentWeather");
        } catch (Exception e) {
            logger.error("Failed to load weather properties in WeatherDao: " + e.getMessage());
        }
    }

    /**
     * Gets weather.
     *
     * @param location the location
     * @return the weather
     */
    public CurrentWeather getWeather(String location) {
        ObjectMapper mapper = new ObjectMapper();
        CurrentWeather currentWeather = null;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(weatherApiUrl + weatherApiKey + "&q=" + location + "&aqi=no"))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                currentWeather = mapper.readValue(response.body(), CurrentWeather.class);
            } else {
                logger.error("Failed to get current weather for location: " + location + ", Status Code: " + response.statusCode());
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching weather data: " + e.getMessage());
        }
        logger.info("Current Weather: " + currentWeather);
        return currentWeather;
    }
}