package com.teamProj.util;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Properties loader test.
 */
class PropertiesLoaderTest implements PropertiesLoader {

    /**
     * Test load weather api properties.
     */
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

    }
}
