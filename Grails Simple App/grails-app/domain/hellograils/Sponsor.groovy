package hellograils

class Sponsor {
		
		String nombre
		String empresa

    static constraints = {
    nombre blank:false
		empresa blank:false
		}
}
