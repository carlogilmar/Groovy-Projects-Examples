
//born Event Bus
def eb = vertx.eventBus()

vertx.setPeriodic(1000, {v->
    eb.send("msg","Hola soy el eventBus mandando un mensajirii", {reply ->

        if(reply.succeeded()){
          println "El mensaje que estoy recibiendo es: ${reply.result().body()}"
        }
        else{
          println "Sin respuesta, Event Bus se siente triste :("
        }

    })
})

