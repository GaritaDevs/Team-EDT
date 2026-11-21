package com.teamProj.restfulNews;

import com.teamProj.entity.CurrentWeather;
import com.teamProj.persistence.WeatherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/weather"})
public class WeatherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String location = req.getParameter("location");

        if (location != null && !location.trim().isEmpty()) {
            WeatherDao dao = new WeatherDao();
            CurrentWeather weather = dao.getWeather(location.trim());

            if (weather != null && weather.getCurrent() != null) {
                WeatherService service = new WeatherService();
                String attireSuggestion = service.getAttireSuggestion(weather);

                req.setAttribute("weather", weather);
                req.setAttribute("attireSuggestion", attireSuggestion);
            } else {
                req.setAttribute("error","Could not retrieve weather data for ZIP code: " + location);
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/weather.jsp");
        dispatcher.forward(req, resp);
    }
}
