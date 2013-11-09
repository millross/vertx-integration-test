package integration_tests.groovy

/**
 * Created with IntelliJ IDEA.
 * User: jez
 * Date: 09/11/2013
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */
import org.vertx.groovy.testtools.VertxTests

import static org.vertx.testtools.VertxAssert.*

// And import static the VertxTests script
// The test methods must begin with "test"
def testBasic() {
    println("Groovy integration test executing")
    def client = vertx.createHttpClient(port: 8080);

    client.getNow('/') { resp ->

        assertEquals(200, resp.statusCode)
        resp.bodyHandler { body ->
            assertEquals("Hello, World", body.toString())
            testComplete()
        }
    }
}

// Make sure you initialize
VertxTests.initialize(this)
VertxTests.startTests(this)