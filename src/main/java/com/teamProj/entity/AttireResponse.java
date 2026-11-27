package com.teamProj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data transfer object representing weather conditions and attire recommendations.
 */
public class AttireResponse {
    private String location;

    @JsonProperty("temp_f")
    private Double tempF;

    private String condition;

    @JsonProperty("clothing_recommendation")
    private String clothingRecommendation;

    @JsonProperty("accessory_recommendation")
    private String accessoryRecommendation;

    /**
     * Constructs an AttireResponse with weather context and structured attire advice.
     *
     * @param location                the city or ZIP code name
     * @param tempF                   the current temperature in Fahrenheit
     * @param condition               the current weather condition text
     * @param clothingRecommendation  recommended base clothing
     * @param accessoryRecommendation recommended weather_specific accessories
     */
    public AttireResponse(String location, Double tempF, String condition, String clothingRecommendation,
                          String accessoryRecommendation) {
        this.location = location;
        this.tempF = tempF;
        this.condition = condition;
        this.clothingRecommendation = clothingRecommendation;
        this.accessoryRecommendation = accessoryRecommendation;
    }

    public String getLocation() { return location; }
    public Double getTempF() { return tempF; }
    public String getCondition() { return condition; }
    public String getClothingRecommendation() { return clothingRecommendation; }
    public String getAccessoryRecommendation() { return accessoryRecommendation; }


}
