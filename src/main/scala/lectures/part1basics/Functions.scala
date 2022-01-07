package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App{

  def aFunction(a: String , b: Int): String =
    a + " " + b

  println(aFunction("hello ", 5))
  // calling a function is also an expression because we can use call function asin the println statement

  def aParameterLessFunction:Int =42
 // println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String , n: Int): String= {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString,n-1)
  }

  println(aRepeatedFunction("helllo ",3))

  // when you need loops use recursion only i.e don't use impertive code in scala language

  def aFunctionWithSideEffects(aString: String): Unit  = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a+ b

    aSmallerFunction(n , n-1)
  }

  /*
  * 1. A greeting function (name , age) => "Hi my name is $name and i am $age year old "
    2. Factorial function 1 * 2 * 3 .. * n
    3. A Fibonacco function
        f(1) = 1
        f(2) = 1
        f(n) = f(n-1) + f(n-2)
        find fibonacchi of nth number
    4. Test if a number is Prime.
  * */

  def aGreetingFunction(name: String , age: Int): String = s"Hi my name is $name and i am $age years old"
  println(aGreetingFunction("gaurav",25))

  def aFactorial(number: Int):Int= {
    if(number==1) 1
    else number*aFactorial(number-1)
  }
  println(aFactorial(5))

  def aFibonacci(number: Int): Int = {
    if(number == 1) 1
    else if (number == 0) 0
    else aFibonacci(number-1) + aFibonacci(number-2)
  }

  println(aFibonacci(2))


  // auxillary function => function under function
  def aPrimeNumber(number: Int): Boolean = {
    @tailrec
    def usedFunctionForPrime(local: Int) : Boolean = {
      if(local <= 1) true
      else (number % local != 0) && usedFunctionForPrime(local-1)
    }

    usedFunctionForPrime(number/2)

  }
  //println(8 % 7)
  println(aPrimeNumber(9))
}
