import io.vertx.groovy.ext.web.Router
def server = vertx.createHttpServer()

def router = Router.router(vertx)

router.route("/hello").handler({ routingContext ->
  // This handler will be called for every request
  def response = routingContext.response()
  response.putHeader("content-type", "text/plain")
  // Write to the response and end it
  response.end("Hello World from Vert.x-Web!")
})

router.route("/counter").handler({ routingContext ->
  // This handler will be called for every request
  def response = routingContext.response()
  response.putHeader("content-type", "text/plain")
  // Write to the response and end it
  response.end("10")
})

router.route("/vertx").handler({ routingContext ->
  // This handler will be called for every request
  def response = routingContext.response()
  response.putHeader("content-type", "text/plain")
  // Write to the response and end it
  response.end("Vertx groovy")
})

router.route("/version").handler({ routingContext ->
  // This handler will be called for every request
  def response = routingContext.response()
  response.putHeader("content-type", "text/plain")
  // Write to the response and end it
  response.end("3.3.3")
})

server.requestHandler(router.&accept).listen(8080)
