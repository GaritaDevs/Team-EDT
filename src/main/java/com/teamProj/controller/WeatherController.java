
package com.teamProj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProj.entity.CurrentWeather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet("/weather")
public class WeatherController extends HttpServlet {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Check if the controller is being called
        getServletContext().log("WeatherController was called!");

        // Get the ZIP code entered by the user
        String zipCode = request.getParameter("location");

        getServletContext().log("ZIP Code received: " + zipCode);

        // Validate the ZIP code
        if (zipCode == null || !zipCode.matches("\\d{5}")) {
            request.setAttribute("error",
                    "Please enter a valid 5-digit ZIP code.");

            request.getRequestDispatcher("/weather.jsp")
                    .forward(request, response);
            return;
        }

        try {
            // Build the URL for our existing Weather REST API
            String apiUrl = request.getScheme() + "://"
                    + request.getServerName() + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/api/current/" + zipCode;

            getServletContext().log("Calling Weather API: " + apiUrl);

            // Create the HTTP request
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            // Send the request to the REST API
            HttpResponse<String> httpResponse = client.send(
                    httpRequest,
                    HttpResponse.BodyHandlers.ofString()
            );

            getServletContext().log(
                    "Weather API response status: "
                            + httpResponse.statusCode()
            );

            // Check the response status
            if (httpResponse.statusCode() != 200) {

                getServletContext().log(
                        "Weather API response: " + httpResponse.body()
                );

                request.setAttribute("error",
                        "Unable to retrieve weather information. Please try again.");

            } else {

                // Convert JSON response into CurrentWeather object
                CurrentWeather weather = objectMapper.readValue(
                        httpResponse.body(),
                        CurrentWeather.class
                );

                // Send weather information to the JSP
                request.setAttribute("weather", weather);

                getServletContext().log(
                        "Weather information successfully retrieved!"
                );
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            getServletContext().log("Weather request was interrupted.", e);

            request.setAttribute("error",
                    "The weather request was interrupted.");

        } catch (Exception e) {

            getServletContext().log(
                    "Error retrieving weather information.", e
            );

            request.setAttribute("error",
                    "Something went wrong retrieving the weather.");
        }

        // Forward the results back to weather.jsp
        request.getRequestDispatcher("/weather.jsp")
                .forward(request, response);
    }
}
