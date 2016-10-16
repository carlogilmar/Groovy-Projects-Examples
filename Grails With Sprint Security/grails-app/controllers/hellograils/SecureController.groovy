package hellograils
import grails.plugin.springsecurity.annotation.Secured
class SecureController {
    @Secured('ROLE_ADMIN')
    def index() {
      render "Esto es algo que nomas puede ver el administrador :D"
    }
}
