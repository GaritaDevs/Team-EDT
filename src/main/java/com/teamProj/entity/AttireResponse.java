package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Data transfer object representing weather conditions and attire recommendations.
 */
public class AttireResponse {
    private String location;

    @JsonProperty("temp_f")
    private Double tempF;

    private String condition;

    @JsonProperty("temperature_tier")
    private TemperatureBracket temperatureTier;

    @JsonProperty("recommended_clothing")
    private List<String> recommendedClothing;

    @JsonProperty("recommended_gear")
    private List<String> recommendedGear;

    /**
     * Constructs an AttireResponse with weather context and structured attire advice.
     *
     * @param location            the city or ZIP code name
     * @param tempF               the current temperature in Fahrenheit
     * @param condition           the current weather condition text
     * @param recommendedClothing recommended base clothing
     * @param recommendedGear     recommended weather-specific gear
     */
    public AttireResponse(String location, Double tempF, String condition,
                          TemperatureBracket temperatureTier,
                          List<String> recommendedClothing,
                          List<String> recommendedGear) {
        this.location = location;
        this.tempF = tempF;
        this.condition = condition;
        this.temperatureTier = temperatureTier;
        this.recommendedClothing = recommendedClothing;
        this.recommendedGear = recommendedGear;
    }

    public String getLocation() { return location; }
    public Double getTempF() { return tempF; }
    public String getCondition() { return condition; }
    public TemperatureBracket getTemperatureTier() { return temperatureTier; }
    public List<String> getRecommendedClothing() { return recommendedClothing; }
    public List<String> getRecommendedGear() { return recommendedGear; }


}
