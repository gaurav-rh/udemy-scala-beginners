package lectures.part2oop

import scala.annotation.tailrec

object PrakharAssignment extends App{
  //def sumInts(a: Int, b: Int): Int ===>returns sum of integer from a to b
  //def sumofSquares(a: Int, b: Int) ===> returns sum of squares of integers from a to b
  //def powerOfTwo(n: Int): Int ===> calculates 2^n

  def sumInts(a: Int, b: Int): Int ={
    @tailrec
    def helper(a: Int, b: Int, accumulator:Int = 0):Int = {
      if(a <= b) helper(a+1,b, accumulator+a)
      else accumulator
    }
    if(a>b) throw new Exception("dekho kya print karta hai")
    else if(a <= b) helper(a,b)
    else b
  }

  println(sumInts(1,10))
  println(sumInts(10,10))
 // println(sumInts(55,20))

  def sumofSquares(a: Int, b: Int): BigInt = {
    @tailrec
    def helper(a: Int, b: Int, accumulator:BigInt = 0):BigInt = {
      if(a <= b) helper(a+1,b, accumulator+(a*a))
      else accumulator
    }
    if(a>b) throw new Exception("dekho kya print karta hai")
    else if(a <= b) helper(a,b)
    else a*a
  }

  println(sumofSquares(2,5))
  println(sumofSquares(1,10))

  def powerOfTwo(n: Int): Int = {
    Math.pow(2,n).toInt
    }
  println(powerOfTwo(5))
  println(powerOfTwo(10))
}
