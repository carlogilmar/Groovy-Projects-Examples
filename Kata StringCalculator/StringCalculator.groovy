class StringCalculator {
  int suma
  List neg
  String separador
  int add (String cadena){
    if (!cadena) return 0
        else
          if(!cadena.contains("[")){
              separador=(cadena.contains("//"))? cadena[2]:','
              cadena=(cadena.contains("//"))? cadena.substring(4) : cadena
          }else{
							
							if(cadena[cadena.indexOf("]")+1] == "[" ){
								separador = cadena.substring(cadena.indexOf("[")+1 ,cadena.indexOf("]"))
								cadena = cadena.substring(cadena.indexOf("]")+1)
								cadena= cadena.replace(cadena.substring(cadena.indexOf("[")+1,cadena.indexOf("]")),separador)
							}
              separador=cadena.substring(cadena.indexOf("[")+1,cadena.indexOf("]"))
              cadena=cadena.substring(cadena.indexOf("]")+2)
          }
          suma=0
          neg=[]//lista vacia
          cadena.replace('\n',",").split(separador).each{
            if(it.toInteger()<0)
                neg.add(it.toInteger())
            else
              if(it.toInteger()<=1000) suma += it.toInteger()
          }
          if(!neg) return suma
          if(neg.size()==1) throw new RuntimeException("Negatives not allow")
          if(neg.size()>1) throw new RuntimeException ("Negatives not allow:"+neg)
        }//method add
}
