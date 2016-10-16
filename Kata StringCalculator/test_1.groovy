import groovy.util.GroovyTestCase;
//----------------------------------------pruebas
class TestKata extends GroovyTestCase {

	def mikata = new Kata()
 	void testOne() {
		assert mikata.add("")==0
		assert mikata.add("0")==0
		assert mikata.add("1")==1
		assert mikata.add("2")==2
		assert mikata.add("19,2")==21
    assert mikata.add("1,2,3,4,5")==15
  }

	void testSaltos(){
		assert mikata.add("1\n2,3")==6
	}

}//class TestKata




//-----------------------------------------clase a probar
class Kata{

int suma=0

	int add(String numbers){
		//si es string vacio o cero
		if (numbers=="" || numbers=="0") return 0

		//si solo es un valor
		if( numbers.split(",").size() == 1){
			//regresa el mismo valor
			 return numbers.toInteger()
		}

		//si hay dos numeros
		if (numbers.split(",").size() == 2){
			//1\n2,3==6
			if(numbers.contains("\n")){//---------------si contiene salto de linea
			//Contine el escape
			return 	numbers.split("\n")[0].toInteger() + numbers.split("\n")[1].split(",")[0].toInteger() + numbers.split("\n")[1].split(",")[1].toInteger()
			}//if
			else{
				//regresa la sumatoria de solo dos numeros
				return numbers.split(",")[0].toInteger() + numbers.split(",")[1].toInteger()
			}//else
		}

		//step 2
		if (numbers.split(",").size()>2){
      //hacer la sumatoria de todos los elementos
      numbers.split(",").size().times{
         suma=suma+numbers.split(",")[it].toInteger()
      }
      return suma

		}

		//step 3


	}//test voir

}




