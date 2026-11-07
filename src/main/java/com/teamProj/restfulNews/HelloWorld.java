package com.teamProj.restfulNews;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/greetings/{name}")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media types "text/plain", "application/json", or "text/html"
    @Produces({"text/plain", "application/json", "text/html"})
    public Response getMessage(@PathParam("name") String name, @Context HttpHeaders headers) {
        List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();
        String baseMessage = "Hello, " + name + "!";
        String output = baseMessage;

        for (MediaType type : acceptableMediaTypes) {
            if (type.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
                output = "{\"message\": \"" + baseMessage + "\"}";
                return Response.status(200).type(MediaType.APPLICATION_JSON).entity(output).build();
            }
            if (type.isCompatible(MediaType.TEXT_HTML_TYPE)) {
                output = "<h3>" + baseMessage + "</h3>";
                return Response.status(200).type(MediaType.TEXT_HTML).entity(output).build();
            }
        }

        return Response.status(200).type(MediaType.TEXT_PLAIN).entity(output).build();
    }
}
