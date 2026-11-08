package com.teamProj.restfulNews;

import com.teamProj.entity.CurrentWeather;
import com.teamProj.util.PropertiesLoader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/current/{location}")
public class Weather implements PropertiesLoader {
    Properties properties;
    String weatherApiKey;
    String weatherApiUrl;
    static String city;
    static String state;
    static String tempF;
    static String tempC;
    static String windMph;
    static String windKph;

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media types "text/plain", "application/json", or "text/html"
    @Produces({"text/plain", "application/json", "text/html"})
    public Response getWeather(@PathParam("location") String location, @Context HttpHeaders headers) {
        ObjectMapper mapper = new ObjectMapper();
        CurrentWeather currentWeather = null;

        assignProperties();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(weatherApiUrl + weatherApiKey + "&q=" + location + "&aqi=no"))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                currentWeather = mapper.readValue(response.body(), CurrentWeather.class);
                city = currentWeather.getLocation().getName() != null ? currentWeather.getLocation().getName() : "Unknown";
                state = currentWeather.getLocation().getRegion() != null ? currentWeather.getLocation().getRegion() : "Unknown";
                tempF = currentWeather.getCurrent().getTempF() != null ? String.valueOf(currentWeather.getCurrent().getTempF()) : "Unknown";
                tempC = currentWeather.getCurrent().getTempC() != null ? String.valueOf(currentWeather.getCurrent().getTempC()) : "Unknown";
                windMph = currentWeather.getCurrent().getWindMph() != null ? String.valueOf(currentWeather.getCurrent().getWindMph()) : "Unknown";
                windKph = currentWeather.getCurrent().getWindKph() != null ? String.valueOf(currentWeather.getCurrent().getWindKph()) : "Unknown";
            }
        } catch (IOException | InterruptedException e) {
            // Should use a logger here
            e.printStackTrace();
        }

        List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();
        for (MediaType type : acceptableMediaTypes) {
            if (type.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
                try {
                    String jsonOutput = mapper.writeValueAsString(currentWeather);
                    return Response.status(200).type(MediaType.APPLICATION_JSON).entity(jsonOutput).build();
                } catch (IOException e) {
                    // Should use a logger here too
                    e.printStackTrace();
                }
            }
            if (type.isCompatible(MediaType.TEXT_HTML_TYPE)) {
                String htmlOutput = convertWeatherToHtml();
                return Response.status(200).type(MediaType.TEXT_HTML).entity(htmlOutput).build();
            }
        }
        String textOutput = convertWeatherToPlainText();
        return Response.status(200).type(MediaType.TEXT_PLAIN).entity(textOutput).build();
    }

    public void assignProperties() {
        try {
            properties = loadProperties("/weatherapi.properties");
            weatherApiKey =  properties.getProperty("key");
            // There are endpoint URLs for data other than current weather which could also be properties
            // e.g. Forecast, History, Alerts, Sports, etc.
            // So an if/else block here could dynamically decide the value of weatherApiUrl based on
            // a user-entered choice.
            weatherApiUrl = properties.getProperty("url.currentWeather");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertWeatherToHtml() {
        // I've left this as a StringBuilder, despite IntelliJ saying it could just be a String
        // because I anticipate that this could be longer and more complex eventually.
        // If that happens, it'll run smoother using a StringBuilder.
        StringBuilder page = new StringBuilder();

        page.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("  <meta charset=\"UTF-8\">\n")
                .append("  <title>Weather API</title>\n")
                .append("  <style>\n")
                .append("  </style>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("  <h2>Current Weather for ").append(city).append(", ")
                .append(state).append("</h2><br><br>\n")
                .append("  <h4>Temperature<h4>\n")
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

    public static String convertWeatherToPlainText() {
        // I've left this as a StringBuilder, despite IntelliJ saying it could just be a String
        // because I anticipate that this could be longer and more complex eventually.
        // If that happens, it'll run smoother using a StringBuilder.
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
