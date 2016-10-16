package com.makingdevs

class PluginService {

  def grailsApplication

  def method() {
    println "Estoy en el serviciio del plugin"
    println grailsApplication
  }
}
