println "Dia 5 del adventure of code"

def cad1="aeibb" //cadena true
def vowels=0 //vocales
def par=0 //pares de letras iguales
def err=0 //numero de pares no aceptados

cad1.size().times{

//vocales
    if (cad1[it] == 'a' || cad1[it] == 'e' || cad1[it] == 'i' || cad1[it] == 'o' || cad1[it] == 'u'){
       vowels ++
    }

//letra doble junta
    //ver que no sea el ultimo elemento de la lista
    if( it != cad1.size()-1 ){
        if( cad1[it] == cad1[it+1]){
             par++
        }
    //ver que el par no sea ab cd pq xy
      if( (cad1[it]+cad1[it+1]) == 'ab'){
            err++
        }

    }


}//times

//resultados

if (vowels >= 3){
    println "Tiene al menos tres vocales"
}
println "Numero de errores hallados: "+ err
println "Pares de letras juntas:" + par

if (vowels >= 3 && err ==0 && par>0){
    println "Cadena ok"
}

