def eb = vertx.eventBus()

eb.consumer("com.makingdevs.fizzbuzz") { message ->
  def replyMessage = message.body().toInteger()
  if(replyMessage % 3 == 0)
    replyMessage = "Fizz"
  else if(replyMessage % 5 == 0)
    replyMessage = "Buzz"
  message.reply(replyMessage)
}
