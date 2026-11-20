package com.teamProj.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.util.PropertiesLoader;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

/**
 * The type Weather dao.
 */
public class WeatherDao implements PropertiesLoader {
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
            System.out.println("Failed to load weather properties in WeatherDao: " + e.getMessage());
            e.printStackTrace();
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
                System.out.println("Failed to fetch weather. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while fetching weather data: " + e.getMessage());
            e.printStackTrace();
        }

        return currentWeather;
    }
}