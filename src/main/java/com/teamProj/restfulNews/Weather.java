package com.teamProj.restfulNews;

import com.teamProj.entity.*;
import com.teamProj.persistence.WeatherDao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * RESTful resource providing current weather details and attire recommendations.
 */
@Path("weather/current/{zipcode}")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Current Weather & Attire", description = "Real-time weather conditions and attire recommendations for US ZIP codes")
@ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Weather data not found for the provided ZIP code",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
})
public class Weather {
    private final WeatherDao dao = new WeatherDao();
    private final WeatherService service = new WeatherService();

    @PathParam("zipcode")
    @Parameter(description = "5-digit US ZIP code", example = "53704",  required = true)
    private String zipCode;

    /**
     * 1. Returns the complete current weather and location payload.
     * URL: GET /Team-EDT/api/weather/current/{zipcode}
     *
     * @return HTTP 200 response containing {@link CurrentWeather} JSON
     */
    @GET
    @Operation(summary = "Get full weather report", description = "Returns the complete current weather and location payload.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of full weather data",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrentWeather.class)))
    public Response getWeather() {
        return Response.ok(getValidWeatherData()).build();
    }

    /**
     * 2. Returns geographic coordinates, region, country, and local time for the ZIP code.
     * URL: GET /Team-EDT/api/weather/current/{zipcode}/location
     *
     * @return HTTP 200 response containing {@link Location} JSON
     */
    @GET
    @Path("/location")
    @Operation(summary = "Get location details", description = "Returns geographic coordinates, region, country, and local time.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of location data",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Location.class)))
    public Response getLocationOnly() {
        Location loc = getValidWeatherData().getLocation();
        return Response.ok(loc).build();
    }

    /**
     * 3. Returns Fahrenheit/Celsius temperatures, feels-like temp, humidity, and condition text.
     * URL: GET /Team-EDT/api/weather/current/{zipcode}/temperature
     *
     * @return HTTP 200 response containing {@link TemperatureResponse} JSON
     */
    @GET
    @Path("/temperature")
    @Operation(summary = "Get temperature details", description = "Returns Fahrenheit/Celsius temperatures, feels-like temp, humidity, and condition text.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of temperature data",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = TemperatureResponse.class)))
    public Response getTemperatureOnly() {
        TemperatureResponse temp = new TemperatureResponse(getValidWeatherData().getCurrent());
        return Response.ok(temp).build();
    }

    /**
     * 4. Returns wind speed (MPH/KPH), direction, gusts, and precipitation.
     * URL: GET /Team-EDT/api/weather/current/{zipcode}/wind
     *
     * @return HTTP 200 response containing {@link WindResponse} JSON
     */
    @GET
    @Path("/wind")
    @Operation(summary = "Get wind and precipitation details", description = "Returns wind speed (MPH/KPH), direction, gusts, and precipitation.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of wind data",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = WindResponse.class)))
    public Response getWindOnly() {
        WindResponse wind = new WindResponse(getValidWeatherData().getCurrent());
        return Response.ok(wind).build();
    }

    /**
     * 5. Returns a weather summary alongside clothing and accessory recommendations.
     * URL: GET /Team-EDT/api/weather/current/{zipcode}/attire
     *
     * @return HTTP 200 response containing {@link AttireResponse} JSON
     */
    @GET
    @Path("/attire")
    @Operation(summary = "Get attire recommendation", description = "Returns a weather summary alongside structured clothing and gear recommendations.")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of attire recommendation",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = AttireResponse.class)))
    public Response getAttire() {
        CurrentWeather weather = getValidWeatherData();
        AttireResponse attire = service.getAttireRecommendation(weather, zipCode);
        return Response.ok(attire).build();
    }

    /**
     * Retrieves validated weather data for the requested ZIP code or throws a 404 JSON response.
     *
     * @return validated {@link CurrentWeather} object
     */
    private CurrentWeather getValidWeatherData() {
        CurrentWeather weather = dao.getWeather(zipCode);
        if (weather == null || weather.getLocation() == null || weather.getCurrent() == null) {
            throw new WebApplicationException(notFoundResponse(zipCode));
        }
        return weather;
    }

    private Response notFoundResponse(String location) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse("Weather data not found for ZIP code: " + location))
                .build();
    }

}