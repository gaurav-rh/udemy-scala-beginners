package lectures.part3fp

object AnonymousFunction extends App {

  //anonymous function
  /** val doubler = new Function1[Int,Int] {
   * override def apply(x:Int):Int =x*2
   * }
   */
  //this can be replace by (LAMBDA)
  val doubler: Int => Int = x => x * 2 // => val doubler = (x:Int) => x*2

  //multiple parameters in LAMBDA

  val adder = (a:Int,b:Int) => a+b // val adder: (Int,Int) => Int = (a,b) = a+b

  // no parameters

  val justDoSomething = () => 3
  //val justDoSomething:()=>Int = () => 3

  //careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // actual call

  //curly braces with lambdas
  val stringToInt = { (string: String) =>
    Int
    string.toInt
  }

    //MOAR syntactic sugar
    val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x+1
    val niceAdder: (Int,Int) => Int = _ + _ // equivalent to (a,b) => a+b

    /**
     * 1.MyLIst: replcae all FunctionsX calls with Lambdas'
     * 2.Rewrite the"special" adder as an anonymous function
     * */
    //2
    val superAdder = (x:Int) => (y:Int) => x + y

  println(superAdder(3)(4))

}
