class StringCalculatorTest extends GroovyTestCase {

  StringCalculator sc = new StringCalculator()

  void testZero(){
   assert sc.add("0") == 0
   assert sc.add("") == 0
  }

  void testOneNumber(){
   assert sc.add("5") == 5
   assert sc.add("9") == 9
   assert sc.add("10") == 10
  }

  void testTwoNumbers(){
   assert sc.add("5,6") == 11
   assert sc.add("9,7") == 16
   assert sc.add("10,12") == 22
  }

  void testAnyNumbers(){
   assert sc.add("1,2,3,4,5,6") == 21
   assert sc.add("1,2,4") == 7
   assert sc.add("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1") == 17
  assert sc.add("100,200,300,500") == 1100
  }

   void testEscape(){
   assert sc.add("1,2\n3,4\n5,6") == 21
   assert sc.add("1\n2,3") == 6
   assert sc.add("100,200\n300,500") == 1100
  }

  void testDifEsc(){
  assert sc.add("//;\n1;2")==3
  assert sc.add("//-\n10-2")==12
  assert sc.add("//-\n10-2-1-1-1")==15
  }

  void testNegativeException(){

    try{
     sc.add("1,2,-1")
  }
  catch(e){
    assert e.message == "Negatives not allow"
  }
  try{
     sc.add("1,2,-1,-3")
  }
  catch(e){
    assert e.message == "Negatives not allow:[-1, -3]"
  }
  }

  void testBignums(){
  assert sc.add("1,2,1005")==3
  }

  void testDelimiter(){
  assert sc.add("//[---]\n1---2---3---4---5") == 15
  assert sc.add("//[---]\n2---3---5") == 10
}

  void testMultipleDelimiters(){
  assert sc.add("//[%][-]\n1-2%3%4-5") == 15
  assert sc.add("//[%][/]\n1%2%3/4/5") == 15
  assert sc.add("//[#][-]\n1-2#3#4-5") == 15
}

	void testLongMultipleDelimiters(){
	 assert sc.add("//[%%%%][---]\n1---2%%%%3%%%%4---5") == 15
	 assert sc.add("//[____][///]\n1____2____3///4///5") == 15
   assert sc.add("//[aaa][iiiii]\n1aaa2iiiii3aaa4iiiii5") == 15
}

}
