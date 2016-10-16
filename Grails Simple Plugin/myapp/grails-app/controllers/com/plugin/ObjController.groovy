package com.plugin

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ObjController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def pluginService

    def index(Integer max) {

      //------------------------------Service del plugin
      println grailsApplication
      pluginService.method()


      params.max = Math.min(max ?: 10, 100)
        respond Obj.list(params), model:[objCount: Obj.count()]
    }

    def show(Obj obj) {
        respond obj
    }

    def create() {
        respond new Obj(params)
    }

    @Transactional
    def save(Obj obj) {
        if (obj == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (obj.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond obj.errors, view:'create'
            return
        }

        obj.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'obj.label', default: 'Obj'), obj.id])
                redirect obj
            }
            '*' { respond obj, [status: CREATED] }
        }
    }

    def edit(Obj obj) {
        respond obj
    }

    @Transactional
    def update(Obj obj) {
        if (obj == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (obj.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond obj.errors, view:'edit'
            return
        }

        obj.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'obj.label', default: 'Obj'), obj.id])
                redirect obj
            }
            '*'{ respond obj, [status: OK] }
        }
    }

    @Transactional
    def delete(Obj obj) {

        if (obj == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        obj.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'obj.label', default: 'Obj'), obj.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'obj.label', default: 'Obj'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
