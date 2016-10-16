import hellograils.*

class BootStrap {

    def init = { servletContext ->

    if (!Usuario.count()){
		def event1 = new Usuario(user:'Itzel', password:'12345',registro:new Date() ).save()
   	def event4 = new Usuario(user:'Vanessa', password:'12345',registro:new Date() ).save()
    def event5 = new Usuario(user:'Monica', password:'12345',registro:new Date() ).save()
    }

    if(!Sponsor.count()){
		def event2 = new Sponsor(nombre:'MakingDevs', empresa:'MakingDevs').save()
    }

    if(!Evento.count()){
		def event3 = new Evento(city:'CDMX', name:'SGNext', startDate:new Date(), endDate:new Date()).save()
 		//has to many
		def g1 = Evento.findByName('SGNext')
		g1.addToVolunteers( new Usuario(user:'Carlo', password:'1234567890',registro:new Date() ))
		g1.addToVolunteers( new Usuario(user:'Gilmar', password:'1234567890',registro:new Date() ))
		g1.save()
    }


    //roles and users----------->Spring Security
    def adminRole = new Role(authority: 'ROLE_ADMIN').save()
    def userRole = new Role(authority: 'ROLE_USER').save()

    if(!User.count()){
    def testUser = new User(username: 'carlo', password: 'carlo').save()
    def testUser1 = new User(username: 'gilmar', password: 'gilmar').save()
    UserRole.create testUser, adminRole
    UserRole.create testUser1, userRole
    }


    UserRole.withSession {
      it.flush()
      it.clear()
    }

		}

    def destroy = {
    }
}
