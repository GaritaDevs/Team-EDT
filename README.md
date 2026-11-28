## Team PROJECT - Web Service Weather Project

## Overview 

With the increasing unpredictability of local weather patterns and severe storm events, developers frequently find themselves checking multiple fragmented sources — local news sites, radar apps, government meteorological portals, and social media feeds — just to get an accurate, localized forecast.
Currently, comprehensive weather data is scattered across complex meteorological interfaces or ad-supported apps cluttered with extraneous information.
Our web service provides a streamlined, single-input platform where developers can simply enter any zip code to instantly access localized, real-time weather conditions and forecasts.
But what makes our web service truly stand out is that we provide actionable, real-world guidance alongside clean, reliable weather data.
Client applications won't have to parse massive third-party payloads or build decision-making logic from scratch.
Instead, our API evaluates live meteorological factors — such as feels-like temperature and active weather conditions — and translates them directly into tailored attire suggestions.

## API Scope: Resources, Operations & Response Types

**Base URL:** `/Team_EDT_war/api`  
**Interactive Swagger UI Documentation:** `/Team_EDT_war/` (OpenAPI JSON spec: `/Team_EDT_war/api/openapi.json`)  
**Authentication:** None required

| Resource | Operation | Path Parameter | Description | Response Type |
| :--- | :--- | :--- | :--- | :--- |
| `/weather/current/{zipcode}` | `GET` | `zipcode` (5-digit US ZIP) | Returns the complete current weather and location payload (`CurrentWeather`). | `application/json` |
| `/weather/current/{zipcode}/location` | `GET` | `zipcode` (5-digit US ZIP) | Returns geographic coordinates, region, country, and local time (`Location`). | `application/json` |
| `/weather/current/{zipcode}/temperature` | `GET` | `zipcode` (5-digit US ZIP) | Returns Fahrenheit/Celsius temperatures, feels-like temp, humidity, and condition text (`TemperatureResponse`). | `application/json` |
| `/weather/current/{zipcode}/wind` | `GET` | `zipcode` (5-digit US ZIP) | Returns wind speed (MPH/KPH), direction, gusts, and precipitation (`WindResponse`). | `application/json` |
| `/weather/current/{zipcode}/attire` | `GET` | `zipcode` (5-digit US ZIP) | Returns weather context alongside structured clothing and gear recommendations (`AttireResponse`). | `application/json` |

### Error Handling
If a ZIP code cannot be found or the upstream weather provider returns no data, the service responds with HTTP `404 Not Found` (`application/json`):
```json
{
  "error": "Weather data not found for ZIP code: 00000"
}
```

### Data Source & Attribution
Real-time weather data is powered by [WeatherAPI.com](https://weatherapi.com).
