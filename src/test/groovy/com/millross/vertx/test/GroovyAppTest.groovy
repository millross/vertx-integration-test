package com.millross.vertx.test
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

class GroovyAppTest {

    @Test
    void testSomething() {
        println("TESTING SOMETHING")
        assertThat(1, is(1))
    }

}