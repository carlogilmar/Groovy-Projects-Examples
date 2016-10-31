def eb = vertx.eventBus()


eb.consumer("msg", {message ->
    println "${message.body()}:::: Hey, how are u?"
    message.reply("No te pongas triste Event Bus, te mando saludos :D")
})

println "Estoy listo para saludar a quien me salude"
