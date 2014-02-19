package com.millross.vertx.test

import org.junit.Ignore
import org.junit.Test
import groovyx.net.http.HTTPBuilder

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

/**
 * @author jez
 */
class GroovyWebIntegrationTest {

    @Test
    @Ignore
    void testHttpCall() {
        def http = new HTTPBuilder("http://localhost:8181")
        def html = http.get( path : '/')
        assertThat(html, is("Bonjour"))
    }

}
