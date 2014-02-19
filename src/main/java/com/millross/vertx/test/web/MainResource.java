package com.millross.vertx.test.web;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author jez
 */
@Path("/")
public class MainResource {

    private static int FIVE_SECOND_READ_TIMEOUT = 5000;

    private RestTemplate restTemplate = new RestTemplate();

    public MainResource() {
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(FIVE_SECOND_READ_TIMEOUT);
    }

    @GET
    @Produces("text/html")
    public String getHomePage() {
        // Trivial sequential request for greeting and greetee
        String greeting = restTemplate.getForObject("http://localhost:8181", String.class);
        String greetee = restTemplate.getForObject("http://localhost:8182", String.class);
        System.out.println("greetee" + greetee);

        return String.format("%s, %s", greeting, greetee);
    }

}
