package lectures.part2oop

object Exceptions extends App{

  val x: String = null
  /**
   * println(x.length)
   * this ^^ will crash with null pointer exception(NPE)
   **/
   //1.throwing and catching exceptions

 // val aWeiredValue: String = throw new NullPointerException

  //throwable classes extends the Throwable class
  //Exception and Error are the major Throwable subtypes


  //2.how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("no int for you")
    else 43

   val anyException =  try{
      //code that may fail
      getInt(true)
    } catch {
      case e: RuntimeException => 3 //println("caught a runtime exception")
      //case p: NullPointerException => println(" ")
    } finally {
      //code that will run no matter what
      //optional
      // does not influence the return type of this expression
      // use finally only for side-effects
      println("finally")
    }

   // 3.how to define your own exceptions
      class MyException extends Exception
      val newException = new MyException

     // throw newException

      /**
       * 1. Crash your program with an OutOfMemoryError
       * 2. Crash with SOError
       * 3. Pocket calculator
       *    -add(x,y)
       *    -subtract(x,y)
       *    -multiply(x,y)
       *    -divide(x,y)
       *
       *    Throw
       *        -OverFlowException if add(x,y) exceeds Int.MAX_VALUE
       *        -UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
       *        -MathCalculationException for division by 0
       * */

      //OOM
      // val array = Array.ofDim(Int.MaxValue)

      //SO
      //def infitine: Int = 1 + infitine
      //val noLimit = infitine

      class OverFlowException extends RuntimeException
      class UnderFlowException extends RuntimeException
      class MathCalculationException extends Exception("division by 0")
      object PocketCalculator {
        def add(x:Int, y: Int ):Int = {
          if(x > 0 && y > 0 && (x+y)<0) throw new OverFlowException
          else if(x<0 && y < 0 && (x + y) > 0) throw new UnderFlowException
          else x +y
        }
        def subtract(x:Int, y: Int ):Int = {
          if(x > 0 && y < 0 && (x-y)<0) throw new OverFlowException
          else if (x < 0 && y > 0 && (x-y)>0) throw new UnderFlowException
          else x - y
        }
        def multiply(x:Int, y: Int ):Int = {
          if(x > 0 && y > 0 && (x*y)<0) throw new OverFlowException
          else if(x < 0 && y < 0 && (x*y)<0) throw new OverFlowException
          else if(x > 0 && y < 0 && (x*y)>0) throw new UnderFlowException
          else if(x < 0 && y > 0 && (x*y)>0) throw new UnderFlowException
          else x*y
        }
        def divide(x:Int, y: Int ):Int = {
          if( y == 0) throw new MathCalculationException
          else x/y
        }
      }

    println(PocketCalculator.divide(2,0))
}
