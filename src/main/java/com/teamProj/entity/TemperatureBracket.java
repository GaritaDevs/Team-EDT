package com.teamProj.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Enum representing temperature tiers and their associated clothing recommendations.
 */
public enum TemperatureBracket {
    FREEZING(Double.NEGATIVE_INFINITY, 32.0,
            Arrays.asList("Heavy winter coat", "Gloves", "Winter hat", "Thermal layers")),
    COLD(32.0, 50.0,
            Arrays.asList("Warm jacket or coat", "Long pants", "Closed-toe shoes")),
    MILD(50.0, 68.0,
            Arrays.asList("Light jacket", "Sweater or long-sleeve shirt", "Long pants")),
    WARM(68.0, 82.0,
            Arrays.asList("T-shirt or light top", "Pants or shorts")),
    HOT(82.0, Double.POSITIVE_INFINITY,
            Arrays.asList("Lightweight breathable top", "Shorts", "Breathable footwear"));

    private final double minTempF;
    private final double maxTempF;
    private final List<String> recommendedItems;

    TemperatureBracket(double minTempF, double maxTempF, List<String> recommendedItems) {
        this.minTempF = minTempF;
        this.maxTempF = maxTempF;
        this.recommendedItems = recommendedItems;
    }

    public List<String> getRecommendedItems() { return recommendedItems; }

    /**
     * Finds the matching {@link TemperatureBracket} for a given Fahrenheit temperature.
     *
     * @param tempF temperature in Fahrenheit
     * @return the matching temperature bracket
     */
    public static TemperatureBracket fromTemperature(double tempF) {
        for (TemperatureBracket bracket : values()) {
            if (tempF >= bracket.minTempF && tempF < bracket.maxTempF) {
                return bracket;
            }
        }
        return MILD;
    }
}
