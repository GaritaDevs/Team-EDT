package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object representing wind and precipitation details.
 */
public class WindResponse {

    @JsonProperty("wind_mph")
    private Double windMph;

    @JsonProperty("wind_kph")
    private Double windKph;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("gust_mph")
    private Double gustMph;

    @JsonProperty("precip_in")
    private Double precipIn;

    /**
     * Constructs a WindResponse from a {@link Current} weather object
     *
     * @param current the current weather data
     */
    public WindResponse(Current current) {
        this.windMph = current.getWindMph();
        this.windKph = current.getWindKph();
        this.windDir = current.getWindDir();
        this.gustMph = current.getGustMph();
        this.precipIn = current.getPrecipIn();
    }

    public Double getWindMph() { return windMph; }
    public Double getWindKph() { return windKph; }
    public String getWindDir() { return windDir; }
    public Double getGustMph() { return gustMph; }
    public Double getPrecipIn() { return precipIn; }


}
