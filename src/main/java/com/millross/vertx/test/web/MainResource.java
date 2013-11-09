package com.millross.vertx.test.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author jez
 */
@Path("/")
public class MainResource {

    @GET
    @Produces("text/html")
    public String getHomePage() {
        return ("Hello, World");
    }

}
