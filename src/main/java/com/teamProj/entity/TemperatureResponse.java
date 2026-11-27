package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object representing temperature and atmospheric conditions.
 */
public class TemperatureResponse {

    @JsonProperty("temp_f")
    private Double tempF;

    @JsonProperty("temp_c")
    private Double tempC;

    @JsonProperty("feelslike_f")
    private Double feelsLikeF;

    @JsonProperty("feelslike_c")
    private Double feelsLikeC;

    private int humidity;
    private String condition;

    /**
     * Constructs a TemperatureResponse from a {@link Current} weather object
     *
     * @param current the current weather data
     */
    public TemperatureResponse(Current current) {
        this.tempF = current.getTempF();
        this.tempC = current.getTempC();
        this.feelsLikeF = current.getFeelslikeF();
        this.feelsLikeC = current.getFeelslikeC();
        this.humidity = current.getHumidity();
        this.condition = (current.getCondition() != null) ? current.getCondition().getText() : "Unknown";
    }

    public Double getTempF() { return tempF; }
    public Double getTempC() { return tempC; }
    public Double getFeelsLikeF() { return feelsLikeF; }
    public Double getFeelsLikeC() { return feelsLikeC; }
    public int getHumidity() { return humidity; }
    public String getCondition() { return condition; }


}
