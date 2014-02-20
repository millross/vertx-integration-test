package integration_tests.groovy
/**
 * Created with IntelliJ IDEA.
 * User: jez
 * Date: 09/11/2013
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */
import org.vertx.groovy.testtools.VertxTests

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

import static org.vertx.testtools.VertxAssert.assertEquals
import static org.vertx.testtools.VertxAssert.testComplete

// And import static the VertxTests script
// The test methods must begin with "test"
def testBasic() {

    CountDownLatch latch = new CountDownLatch(2)
    println "Starting up stub servers"
    [
        [
            port: 8081,
            handler: { request ->
                request.response.putHeader("Content-Type", "text/plain")
                request.response.end("Bonjour")
            }
        ],
        [
            port: 8082,
            handler: { request ->
                request.response.putHeader("Content-Type", "text/plain")
                request.response.end("groovy")
            }
        ]
    ].each {
        def server = vertx.createHttpServer()
        server.requestHandler(it.handler)
        server.listen(it.port, "localhost") {asyncResult ->
            latch.countDown()
        }
    }
    latch.await(400, TimeUnit.MILLISECONDS)

    def client = vertx.createHttpClient(port: 8080);

    client.getNow('/') { resp ->

        assertEquals(200, resp.statusCode)
        resp.bodyHandler { body ->
            assertEquals("Bonjour, groovy", body.toString())
            testComplete()
        }
    }
}

// Make sure you initialize
VertxTests.initialize(this)
VertxTests.startTests(this)