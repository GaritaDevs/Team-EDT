package com.teamProj.restfulNews;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

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
        ),
        servers = {@Server(url = "/Team_EDT_war", description = "Local Tomcat Server")}
)
public class WeatherApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<>();
        h.add(Weather.class);
        return h;
    }

    @Override
    public Set<Object> getSingletons() {
        OpenApiResource openApiResource = new OpenApiResource();
        openApiResource.setResourcePackages(Collections.singleton("com.teamProj.restfulNews"));
        return Collections.singleton(openApiResource);
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.server.wadl.disableWadl", true);
        return props;
    }
}
