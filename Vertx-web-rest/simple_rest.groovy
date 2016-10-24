import io.vertx.groovy.ext.web.Router
import io.vertx.groovy.ext.web.handler.BodyHandler

def handleGetProduct(routingContext) {
  def productID = routingContext.request().getParam("productID")
  def toEmail = routingContext.request().getParam("toEmail")
  def ccEmail = routingContext.request().getParam("ccEmail")
  def ccoEmail = routingContext.request().getParam("ccoEmail")

  println "Valores recibidos"
  println "Email: "+toEmail
  println "CC;"+ccEmail

  def response = routingContext.response()
//  if (productID == null) {
//    this.sendError(400, response)
//  } else {
        response.putHeader("content-type", "application/json").end("Id encontrado y enviado a "+toEmail)
//  }
}

def sendError(statusCode, response) {
  response.setStatusCode(statusCode).end()
}

def router = Router.router(vertx)
router.route().handler(BodyHandler.create())
router.get("/products/:productID/:toEmail/:ccEmail/:ccoEmail").handler(this.&handleGetProduct)
vertx.createHttpServer().requestHandler(router.&accept).listen(8080)
