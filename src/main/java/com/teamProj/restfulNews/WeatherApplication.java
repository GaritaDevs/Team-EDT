package com.teamProj.restfulNews;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Weather application.
 */
@ApplicationPath("/api")
public class WeatherApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<>();
        h.add(Weather.class);
        return h;
    }
}
