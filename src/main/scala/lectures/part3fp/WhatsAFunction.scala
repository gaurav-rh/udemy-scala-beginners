package lectures.part3fp

object WhatsAFunction extends App{

  //DREAM : use functions as first class elements

  //problem : OOP
  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element *2
  }
  println(doubler(2)) // doubler acts like a function
  // doubler is an instance of a function like class can be called as a function

  // function type = Function..Function22
  //Function1[A,B]
  val stringToIntConverter = new Function[String,Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("4") + 7)

  val adder:((Int,Int)=>Int) = new Function2[Int, Int, Int] {
    override def apply(a:Int, b:Int):Int = a+b
  }

  //Function type = Function2[A,B,R] === (A,B)=>R

  /**
   * all scala functions are objects or instances of classes derived from Function1..Function22
   * */

  /*
  * 1. a function which takes 2 strings and concatenates them
  * 2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an Int as argument and returns another function which takes and Int and returns an Int
        -define whats the type of the function
        -how to do it
  * */

  def concatenator: (String,String)=>String = new Function2[String,String,String] {
    override def apply(string1:String, string2: String): String = string1 + string2
  }
  println(concatenator("yoss","boyy"))
/*  val dekho = new Function1[Int,(Int=>Int)] = {
    override def apply(value:Int): (Int=>Int) = Function1[Int]
  }*/

// higher order function either receive functions as parameter or return function

  //FUnction1[Int,Function1[Int,Int]]
  val superAdder: Function1[Int,Function1[Int,Int]] = new Function1[Int,Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

    val adder3 = superAdder(3)
    println(adder3(4))
    println(superAdder(3)(4)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A) : B
}
