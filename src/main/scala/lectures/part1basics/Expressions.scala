package lectures.part1basics

object Expressions extends App{

  //expressions

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4) // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)  // == != > >= < <=

  println(!(1 == x)) // ! && ||

  var aVariable = 2
  aVariable += 3 // also work with -= *= /=(these all are side effects)
  println(aVariable)


  // Instruction vs Expression
  /*
  * -instruction is something which you tell the computer to do eg: print or change the variable etc
  * -an expression is something that has a value and or a type ==> used in functional programming
  * i.e every single bit of your code will compute a value
  */
  //IF EXPRESSION

  val aCondition = true
  val aConditionedValue = if(aCondition) 9 else 2 // if expression not an instruction
  println(aConditionedValue)
  println(if(aCondition) 9 else 2)


  var i = 0
  val aWhile = while (i<10){
    println(i)
    i += 1
  }

  // never write loops in scala

  //everything in scala is an Expression ! it holds a value (type or unit)

  val aWeirdValue = (aVariable = 3) // Unit ===Void
  println(aWeirdValue)

  // side effects : println(), whiles , reasigning

  // code blocks alse hold a value i.e last line of code block hence its also an expression

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "never"
  }


  /* 1. difference between "hello world" vs println("hello world")?
    * => "hello world" is a value of type string or a string literal whereas
    * println("hello world") is a side effect and they are expressions returning unit
    *hence types of these are different first is string and other is unit
    *also println has a side effect of printing on consol 
  */
  //2.

   val someValue = {
     2<3
   }

   val someOtherValue = {
     if(someValue) 239 else 986
     42
   }
   /*
   *here first code block is of type boolean 
   *second code block is Int type holding value 42 here if expression is irrelevant
   */

}
