package com.millross.vertx.test

import org.junit.Test
import groovyx.net.http.HTTPBuilder

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

/**
 * @author jez
 */
class GroovyWebIntegrationTest {

    @Test
    void testHttpCall() {
        def http = new HTTPBuilder("http://localhost:8080")
        def html = http.get( path : '/')
        assertThat(html, is("Hello, World"))
    }

}
