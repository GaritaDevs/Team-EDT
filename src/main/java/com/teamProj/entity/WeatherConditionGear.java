package com.teamProj.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Enum mapping weather conditions to required weather accessories.
 */
public enum WeatherConditionGear {
    PRECIPITATION(Arrays.asList("rain", "drizzle", "shower"),
            Arrays.asList("Umbrella", "Waterproof rain jacket")),
    WINTER_PRECIPITATION(Arrays.asList("snow", "sleet", "blizzard"),
            Arrays.asList("Waterproof snow boots", "Wool socks")),
    SUNNY(Arrays.asList("sunny", "clear"),
            Arrays.asList("Sunglasses", "Sunscreen")),
    NONE(Collections.emptyList(),
            Collections.emptyList());

    private final List<String> keywords;
    private final List<String> gearItems;

    WeatherConditionGear(List<String> keywords, List<String> gearItems) {
        this.keywords = keywords;
        this.gearItems = gearItems;
    }

    public List<String> getGearItems() { return gearItems; }

    /**
     * Matches condition text against known weather keywords to determine needed gear.
     *
     * @param conditionText raw weather condition
     * @return the matching {@link WeatherConditionGear} enum constant
     */
    public static WeatherConditionGear fromCondition(String conditionText) {
        if (conditionText == null) {
            return NONE;
        }
        String normalized = conditionText.toLowerCase();
        for (WeatherConditionGear gear : values()) {
            for (String keyword : gear.keywords) {
                if (normalized.contains(keyword)) {
                    return gear;
                }
            }
        }
        return NONE;
    }
}
