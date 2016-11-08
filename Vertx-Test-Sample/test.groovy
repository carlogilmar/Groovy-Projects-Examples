import io.vertx.groovy.ext.unit.TestSuite
import io.vertx.groovy.core.Vertx
import io.vertx.groovy.core.http.HttpClient


//Configuración para la TestSuite
def options = [
    reporters:
    [
       [ to:"console" ]
    ]
]

//Create TestSuite
def suite = TestSuite.create("the_test_suite")

suite.before({ context ->
  def async = context.async()
  vertx.deployVerticle("fizzbuzz.groovy"){ ar ->
    context.assertTrue(ar.succeeded())
    async.complete()
  }
  //vertx.deployVerticle("fizzbuzz.groovy", context.asyncAssertSuccess())
}).test("my_test_case_1", { context ->
  def async = context.async()
  vertx.eventBus().send("com.makingdevs.fizzbuzz", 2) { response ->
    context.assertEquals(2, response.result.body())
    async.complete()
  }
}).test("my_test_case_2", { context ->
  def async = context.async()
  vertx.eventBus().send("com.makingdevs.fizzbuzz", 3) { response ->
    context.assertEquals("Fizz", response.result.body())
    async.complete()
  }
}).test("my_test_case_3", { context ->
  def async = context.async()
  vertx.eventBus().send("com.makingdevs.fizzbuzz", 5) { response ->
    context.assertEquals("Buzz", response.result.body())
    async.complete()
  }
}).test("my_test_case_4", { context ->
  def async = context.async()

  vertx.eventBus().with {
    send("com.makingdevs.fizzbuzz", 7) { response ->
      context.assertEquals(7, response.result.body())
    }
    send("com.makingdevs.fizzbuzz", 9) { response ->
      context.assertEquals("Fizz", response.result.body())
    }
    send("com.makingdevs.fizzbuzz", 10) { response ->
      context.assertEquals("Buzz", response.result.body())
    }
    async.complete()
  }
}).after({ context ->
  println "After"
})


//Run Suite
def completion = suite.run(options)


