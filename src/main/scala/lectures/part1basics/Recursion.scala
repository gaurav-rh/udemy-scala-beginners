package lectures.part1basics
import scala.annotation.tailrec
import scala.jdk.Accumulator

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
  //println(anotherFactorial(5000)) //it'll run

  //when you need to use loops , use _tail_ recursion
  /*
    Exercises:
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  def concatenator(aString:String , n: Int, accumulator: String) : String = {
    if(n>=0) concatenator(aString, n-1, accumulator+" "+aString)
    else accumulator
  }
  println(concatenator("print",5,""))

  def aPrimeNumber(num:Int):Boolean = {
    if(num==1) true
    def helper(index:Int): Boolean = {
      if((num%index !=0) && index<num/2 ){
        helper(index+1)
      } else{
          if(index<num/2) false
          else true
        }
      }
    helper(2)
  }
   // println(aPrimeNumber(2))

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


