package com.teamProj.restfulNews;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.Current;
import com.teamProj.entity.CurrentWeather;
import com.teamProj.entity.Location;
import com.teamProj.persistence.WeatherDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Weather Resource providing multiple GET endpoints.
 */
@Path("/current/{location}")
public class Weather {

    /**
     * 1. Full weather report supporting JSON, HTML, and Plain Text.
     * URL: GET /Team-EDT/api/current/{location}
     *
     * @param location the location
     * @param headers  the headers
     * @return the weather
     */
    @GET
    @Produces({"text/plain", "application/json", "text/html"})
    public Response getWeather(@PathParam("location") String location, @Context HttpHeaders headers) {
        WeatherDao dao = new WeatherDao();
        CurrentWeather currentWeather = dao.getWeather(location);

        if (currentWeather == null) {
            return notFoundResponse(location);
        }

        String city = currentWeather.getLocation().getName() != null ? currentWeather.getLocation().getName() : "Unknown";
        String state = currentWeather.getLocation().getRegion() != null ? currentWeather.getLocation().getRegion() : "Unknown";
        String tempF = currentWeather.getCurrent().getTempF() != null ? String.valueOf(currentWeather.getCurrent().getTempF()) : "Unknown";
        String tempC = currentWeather.getCurrent().getTempC() != null ? String.valueOf(currentWeather.getCurrent().getTempC()) : "Unknown";
        String windMph = currentWeather.getCurrent().getWindMph() != null ? String.valueOf(currentWeather.getCurrent().getWindMph()) : "Unknown";
        String windKph = currentWeather.getCurrent().getWindKph() != null ? String.valueOf(currentWeather.getCurrent().getWindKph()) : "Unknown";

        ObjectMapper mapper = new ObjectMapper();
        List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();

        for (MediaType type : acceptableMediaTypes) {
            if (type.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
                try {
                    String jsonOutput = mapper.writeValueAsString(currentWeather);
                    return Response.status(200).type(MediaType.APPLICATION_JSON).entity(jsonOutput).build();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (type.isCompatible(MediaType.TEXT_HTML_TYPE)) {
                String htmlOutput = convertWeatherToHtml(city, state, tempF, tempC, windMph, windKph);
                return Response.status(200).type(MediaType.TEXT_HTML).entity(htmlOutput).build();
            }
        }

        String textOutput = convertWeatherToPlainText(city, state, tempF, tempC, windMph, windKph);
        return Response.status(200).type(MediaType.TEXT_PLAIN).entity(textOutput).build();
    }

    /**
     * 2. Returns ONLY geographic & time info for the location.
     * URL: GET /Team-EDT/api/current/{location}/location
     *
     * @param location the location
     * @return the location only
     */
    @GET
    @Path("/location")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocationOnly(@PathParam("location") String location) {
        WeatherDao dao = new WeatherDao();
        CurrentWeather weather = dao.getWeather(location);
        if (weather == null || weather.getLocation() == null) {
            return notFoundResponse(location);
        }

        Location loc = weather.getLocation();
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
     * @param location the location
     * @return the temperature only
     */
    @GET
    @Path("/temperature")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemperatureOnly(@PathParam("location") String location) {
        WeatherDao dao = new WeatherDao();
        CurrentWeather weather = dao.getWeather(location);
        if (weather == null || weather.getCurrent() == null) {
            return notFoundResponse(location);
        }

        Current current = weather.getCurrent();
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
     * @param location the location
     * @return the wind only
     */
    @GET
    @Path("/wind")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWindOnly(@PathParam("location") String location) {
        WeatherDao dao = new WeatherDao();
        CurrentWeather weather = dao.getWeather(location);
        if (weather == null || weather.getCurrent() == null) {
            return notFoundResponse(location);
        }

        Current current = weather.getCurrent();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("wind_mph", current.getWindMph());
        result.put("wind_kph", current.getWindKph());
        result.put("wind_dir", current.getWindDir());
        result.put("gust_mph", current.getGustMph());
        result.put("precip_in", current.getPrecipIn());

        return toJsonResponse(result);
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

    private String convertWeatherToHtml(String city, String state, String tempF, String tempC, String windMph, String windKph) {
        StringBuilder page = new StringBuilder();
        page.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("  <meta charset=\"UTF-8\">\n")
                .append("  <title>Weather API</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("  <h2>Current Weather for ").append(city).append(", ").append(state).append("</h2><br><br>\n")
                .append("  <h4>Temperature</h4>\n")
                .append("  <ul>\n")
                .append("    <li>Fahrenheit: ").append(tempF).append("</li>\n")
                .append("    <li>Celsius: ").append(tempC).append("</li>\n")
                .append("  </ul><br><br>\n")
                .append("  <h4>Wind Speed</h4>\n")
                .append("  <ul>\n")
                .append("    <li>MPH: ").append(windMph).append("</li>\n")
                .append("    <li>KPH: ").append(windKph).append("</li>\n")
                .append("  </ul>\n")
                .append("</body>\n")
                .append("</html>\n");
        return page.toString();
    }

    private String convertWeatherToPlainText(String city, String state, String tempF, String tempC, String windMph, String windKph) {
        StringBuilder text = new StringBuilder();
        text.append("==================================================\n");
        text.append("                  WEATHER REPORT                  \n");
        text.append("==================================================\n\n");
        text.append("Location: ").append(city).append(", ").append(state).append("\n");
        text.append("Temperature\n");
        text.append(" - Fahrenheit: ").append(tempF).append("\n");
        text.append(" - Celsius: ").append(tempC).append("\n");
        text.append("Wind Speed\n");
        text.append(" - MPH: ").append(windMph).append("\n");
        text.append(" - KPH: ").append(windKph).append("\n");
        text.append("--------------------------------------------------\n\n");
        return text.toString();
    }
}