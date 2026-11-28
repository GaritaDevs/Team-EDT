package com.teamProj.restfulNews;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures the JAX-RS application path and registers RESTful and Swagger (OpenAPI) resources.
 */
@ApplicationPath("/api")
@OpenAPIDefinition(
        info = @Info(
                title = "Weather & Attire Recommendation API",
                version = "1.0.0",
                description = "A RESTful web service providing real-time weather conditions " +
                        "and structured attire recommendations for any valid 5-digit US ZIP code.  " +
                        "All endpoints return application/json responses."
        )
)
public class WeatherApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<>();
        h.add(Weather.class);
        h.add(OpenApiResource.class);
        return h;
    }
}
