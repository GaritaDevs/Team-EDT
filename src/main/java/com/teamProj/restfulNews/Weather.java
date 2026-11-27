package com.teamProj.restfulNews;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.AttireResponse;
import com.teamProj.entity.Current;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.entity.Location;
import com.teamProj.persistence.WeatherDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Weather Resource providing multiple GET endpoints.
 */
@Path("/current/{zipcode}")
public class Weather {
    private final WeatherDao dao = new WeatherDao();
    private final WeatherService service = new WeatherService();

    @PathParam("zipcode")
    private String zipCode;

    /**
     * 1. Full weather report supporting JSON.
     * URL: GET /Team-EDT/api/current/{location}
     *
     * @return the full weather report
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeather() {
        return toJsonResponse(getValidWeatherData());
    }

    /**
     * 2. Returns ONLY geographic & time info for the location.
     * URL: GET /Team-EDT/api/current/{location}/location
     *
     * @return the location only
     */
    @GET
    @Path("/location")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocationOnly() {

        Location loc = getValidWeatherData().getLocation();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", loc.getName());
        result.put("region", loc.getRegion());
        result.put("country", loc.getCountry());
        result.put("lat", loc.getLat());
        result.put("lon", loc.getLon());
        result.put("localtime", loc.getLocaltime());

        return toJsonResponse(result);
    }

    /**
     * 3. Returns ONLY temperature & condition details.
     * URL: GET /Team-EDT/api/current/{location}/temperature
     *
     * @return the temperature only
     */
    @GET
    @Path("/temperature")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemperatureOnly() {

        Current current = getValidWeatherData().getCurrent();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("temp_f", current.getTempF());
        result.put("temp_c", current.getTempC());
        result.put("feelslike_f", current.getFeelslikeF());
        result.put("feelslike_c", current.getFeelslikeC());
        result.put("humidity", current.getHumidity());
        result.put("condition", current.getCondition() != null ? current.getCondition().getText() : "Unknown");

        return toJsonResponse(result);
    }

    /**
     * 4. Returns ONLY wind & precipitation info.
     * URL: GET /Team-EDT/api/current/{location}/wind
     *
     * @return the wind only
     */
    @GET
    @Path("/wind")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWindOnly() {

        Current current = getValidWeatherData().getCurrent();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("wind_mph", current.getWindMph());
        result.put("wind_kph", current.getWindKph());
        result.put("wind_dir", current.getWindDir());
        result.put("gust_mph", current.getGustMph());
        result.put("precip_in", current.getPrecipIn());

        return toJsonResponse(result);
    }

    /**
     * 5. Returns temp_f, condition, and suggestion for attire based on temp_f and condition
     * URL: GET /Team-EDT/api/current/{location}/attire
     *
     * @return attire suggestion
     */
    @GET
    @Path("/attire")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAttire() {
        CurrentWeather weather = getValidWeatherData();
        AttireResponse attire = service.getAttireRecommendation(weather, zipCode);
        return Response.ok(attire).build();
    }

    private Response toJsonResponse(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonOutput = mapper.writeValueAsString(data);
            return Response.status(Response.Status.OK)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(jsonOutput)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .type(MediaType.APPLICATION_JSON)
                    .entity("{\"error\": \"Failed to serialize JSON response\"}")
                    .build();
        }
    }

    private Response notFoundResponse(String location) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity("{\"error\": \"Weather data not found for location: " + location + "\"}")
                .build();
    }

    /**
     * Helper method to return either a valid CurrentWeather object, or throw an exception
     * @return validated CurrentWeather object
     */
    private CurrentWeather getValidWeatherData() {
        CurrentWeather weather = dao.getWeather(zipCode);
        if (weather == null || weather.getLocation() == null || weather.getCurrent() == null) {
            throw new javax.ws.rs.WebApplicationException(notFoundResponse(zipCode));
        }
        return weather;
    }
}