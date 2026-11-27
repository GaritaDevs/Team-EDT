package com.teamProj.restfulNews;

import com.teamProj.entity.AttireResponse;
import com.teamProj.entity.Current;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.entity.TemperatureBracket;
import com.teamProj.entity.WeatherConditionGear;

/**
 * Service class responsible for evaluating weather conditions and generating structured
 * attire recommendations using domain enums.
 */
public class WeatherService {

    /**
     * Generates an {@link AttireResponse} based on current temperature and weather conditions.
     *
     * @param weather         the validated {@link CurrentWeather} data
     * @param fallbackZipcode ZIP code to use if the location name is unavailable
     * @return                structured {@link AttireResponse} object
     */
    public AttireResponse getAttireRecommendation(CurrentWeather weather, String fallbackZipcode) {
        Current current = weather.getCurrent();
        String locationName = (weather.getLocation()) != null && weather.getLocation().getName() != null
                ? weather.getLocation().getName()
                : fallbackZipcode;

        Double effectiveTempF = (current.getFeelslikeF() != null)
                ? current.getFeelslikeF()
                : current.getTempF();

        String conditionText = (current.getCondition() != null && current.getCondition().getText() != null)
                ? current.getCondition().getText()
                : "Unknown";

        TemperatureBracket bracket = (effectiveTempF != null)
                ? TemperatureBracket.fromTemperature(effectiveTempF)
                : TemperatureBracket.MILD;

        WeatherConditionGear gear = WeatherConditionGear.fromCondition(conditionText);

        return new AttireResponse(
                locationName,
                current.getTempF(),
                conditionText,
                bracket,
                bracket.getRecommendedItems(),
                gear.getGearItems()
        );
    }
}
