package lectures.part1basics
import scala.annotation.tailrec

object Recursion extends App {
  def factorial(num: Int): Int = {
    if (num <= 1) 1
    else {
      println("for factorial of " + num + "we need to calculate factorial of " + (num - 1))
      val result = num * factorial(num - 1)
      result
    }

  }

  println(factorial(10))

  /*
  recursion has a major limitation of stack overflow i.e here if we want to calculate
  factorial of 5000 it'll shoe stack overflow error
  */
  //println(factorial(5000))

  def anotherFactorial(num: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x < 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(num, 1)
  }


  /*
  anotherFactorial(10) = factorialHelper(10,1)
  = factorialHelper(9, 10*1)
  = factorialHelper(8, 9*10*1)
  = factorialHelper(7, 8*9*10*1)
  .
  .
  .
  =factorialHelper(1,1*2*3*4*5*6*7*8*9*10*1)
  =1*2*3*4*5*6*7*8*9*10
  */

  //here no stackoverflow problem
  println(anotherFactorial(5000)) //it'll run

  //when you need to use loops , use _tail_ recursion
  /*
    Exercises:
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
