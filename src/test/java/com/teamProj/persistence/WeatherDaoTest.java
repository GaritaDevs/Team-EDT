package com.teamProj.persistence;

import com.teamProj.entity.CurrentWeather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link WeatherDao}.
 */
class WeatherDaoTest {

    private WeatherDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new WeatherDao();
    }

    /**
     * Gets weather by city success.
     */
    @Test
    void getWeatherByCitySuccess() {
        CurrentWeather weather = dao.getWeather("Madison");

        assertNotNull(weather, "Expected CurrentWeather response not to be null");
        assertNotNull(weather.getLocation(), "Expected Location object not to be null");
        assertEquals("Madison", weather.getLocation().getName());
        assertNotNull(weather.getCurrent(), "Expected Current object not to be null");
        assertNotNull(weather.getCurrent().getTempF());
        assertNotNull(weather.getCurrent().getTempC());
    }

    /**
     * Gets weather by zip code success.
     */
    @Test
    void getWeatherByZipCodeSuccess() {
        CurrentWeather weather = dao.getWeather("53703");

        assertNotNull(weather);
        assertNotNull(weather.getLocation());
        assertEquals("Madison", weather.getLocation().getName());
        assertNotNull(weather.getCurrent());
    }

    /**
     * Gets weather invalid location returns null.
     */
    @Test
    void getWeatherInvalidLocationReturnsNull() {
        CurrentWeather weather = dao.getWeather("InvalidLocationn");

        assertNull(weather, "Expected null when WeatherAPI returns a non-200 error for an invalid location");
    }
}