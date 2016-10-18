import io.vertx.ext.mail.StartTLSOptions
import io.vertx.groovy.ext.mail.MailClient
def config = [:]
config.hostname = "smtp.gmail.com"
config.port = 587
config.starttls = "REQUIRED"
config.username = "youremail@gmail.com"
config.password = "yourpassword"

def mailClient = MailClient.createShared(vertx, config)

def message = [:]
message.from = "something@gmail.com"
message.to = "something@.com"
message.cc = "Another User <another@example.net>"
message.text = "this is the plain message text"
message.html = "this is html text <a href=\"http://vertx.io\">vertx.io</a>"

mailClient.sendMail(message, { result ->
  if (result.succeeded()) {
    println(result.result())
  } else {
    result.cause().printStackTrace()
  }
})
