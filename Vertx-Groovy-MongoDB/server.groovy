import io.vertx.groovy.core.Vertx
import io.vertx.groovy.ext.mongo.MongoClient

def config = Vertx.currentContext().config()

def uri = config.mongo_uri
if (uri == null) {
  uri = "mongodb://localhost:27017"
}
def db = config.mongo_db
if (db == null) {
  db = "test1"
}

def mongoconfig = [
  connection_string:uri,
  db_name:db
]

def mongoClient = MongoClient.createShared(vertx, mongoconfig)

def person1 = [
  itemId:"12345",
  name:"Carlo",
  blog:"carlogilmar12@gmail.com",
  twitter:"karlosins"
]

  mongoClient.save("people", person1, { id ->
    println("Inserted id: ${id.result()}")

    mongoClient.find("people", [
        itemId:"12345"
    ], { res ->
    println("Name is ${res.result()[0].name}")

  })

})