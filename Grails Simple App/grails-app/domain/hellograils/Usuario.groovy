package hellograils

class Usuario {
		
		String user
		String password
		Date registro
				
    static constraints = {
    user size:1..15
		password size:1..10
		registro()
		
		}
}
