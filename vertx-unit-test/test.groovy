import groovy.transform.Field
import io.vertx.groovy.ext.unit.TestSuite
import io.vertx.groovy.core.Vertx

def options = [
reporters:[
[
to:"console"
]
]
]

def suite = TestSuite.create("the_test_suite")

suite.before({ context ->
  vertx.deployVerticle("webserver.groovy")
})

// Specifying the test names seems ugly...
suite.test("some_test1", { context ->
  // Send a request and get a response
  def client = vertx.createHttpClient()
  def async = context.async()
  client.getNow(8080, "localhost", "/", { resp ->
    resp.bodyHandler({ body ->
      context.assertEquals("Hello World!", body.toString("UTF-8"))
    })
    client.close()
    async.complete()
  })
})

suite.run(options)
