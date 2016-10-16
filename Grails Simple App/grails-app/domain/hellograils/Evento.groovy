package hellograils

class Evento {
		
		String city
		String name
		Date startDate
		Date endDate
		static hasMany = [volunteers: Usuario]
		
    static constraints = {
			city()
			name()
			startDate()
			endDate()
		}
}
