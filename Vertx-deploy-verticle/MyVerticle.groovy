import io.vertx.lang.groovy.GroovyVerticle;

public class HelloWorldHttpVerticle extends GroovyVerticle {

  public void start() {
    println "Iniciando el deploy de server.groovy verticle"
    def options = [
      worker:true
      ]
    vertx.deployVerticle("server.groovy", options)
  }

  public void stop() {
    println("Stopping")
  }
}
