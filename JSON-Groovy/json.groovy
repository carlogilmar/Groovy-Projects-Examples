import groovy.json.JsonSlurper
import groovy.json.JsonOutput

String inputFile = 'data.json'
String fileContents = new File(inputFile).getText('UTF-8')

def jsonSlurper = new JsonSlurper()
def jsonObject = jsonSlurper.parseText(fileContents)

println "JSONObject : " + jsonObject
println "JSONObject type : " + jsonObject.getClass()
println "JSONObject pretty printed"
println "========================="
println JsonOutput.prettyPrint(fileContents)
println "Individual Attributes"
println "---------------------"
println "JSONObject Name : " + jsonObject.name
println "JSONObject day : " + jsonObject.day
println "JSONObject message: " + jsonObject.message

