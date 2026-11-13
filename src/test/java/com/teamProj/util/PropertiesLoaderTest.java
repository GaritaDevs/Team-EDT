package com.teamProj.util;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesLoaderTest implements PropertiesLoader {

    @Test
    void testLoadWeatherApiProperties() {

        Properties properties =
                loadProperties("/weatherapi.properties");

        assertNotNull(properties, "Properties should not be null");

        assertNotNull(
                properties.getProperty("key"),
                "API key should be loaded"
        );

        assertFalse(
                properties.getProperty("key").isEmpty(),
                "API key should not be empty"
        );

        assertEquals(
                "https://api.weatherapi.com/v1/current.json?key=",
                properties.getProperty("url.currentWeather")
        );
    }
}