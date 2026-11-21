package com.teamProj.restfulNews;

import com.teamProj.entity.Current;
import com.teamProj.entity.CurrentWeather;

public class WeatherService {

    public String getAttireSuggestion(CurrentWeather weather) {
        if (weather == null || weather.getCurrent() == null) {
            return "No weather data available to suggest attire.";
        }

        Current current = weather.getCurrent();
        double tempF = ((Number) (current.getFeelslikeF() != null
                ? current.getFeelslikeF()
                : current.getTempF())).doubleValue();
        String condition = (current.getCondition() != null && current.getCondition().getText() != null)
                ? current.getCondition().getText().toLowerCase()
                : "";

        StringBuilder advice = new StringBuilder();

        if (tempF < 32) {
            advice.append("Heavy winter coat, gloves, hat, and warm layers.");
        } else if (tempF < 50) {
            advice.append("Warm jacket or coat, long pants, and closed-toe shoes.");
        } else if (tempF < 68) {
            advice.append("Light jacket, sweater, or long-sleeve shirt.");
        } else if (tempF < 82) {
            advice.append("T-shirt or light top with pants or shorts.");
        } else {
            advice.append("Lightweight, breathable clothing and shorts.");
        }

        if (condition.contains("rain") || condition.contains("drizzle") || condition.contains("shower")) {
            advice.append("  Bring an umbrella or rain jacket.");
        } else if (condition.contains("snow") || condition.contains("sleet")) {
            advice.append("  Wear waterproof snow boots.");
        } else if (condition.contains("sunny") || condition.contains("clear")) {
            advice.append("  Sunglasses and sunscreen recommended.");
        }

        return advice.toString();
    }
}
