import io.vertx.groovy.ext.unit.TestSuite
import io.vertx.groovy.ext.unit.TestContext
import io.vertx.groovy.core.Vertx

def suite = TestSuite.create("the_test_suite")

vertx.deployVerticle("webserver.groovy", context.asyncAssertSuccess());

suite.run([
reporters:[
[
to:"console"
]
]
])
