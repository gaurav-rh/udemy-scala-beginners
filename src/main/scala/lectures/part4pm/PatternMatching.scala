package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "the two"
    case 3 => "the three"
    case _ => "something else" // WILDCARD
  }

  println(x)
  println(description)

  //It can DECOMPOSE values
  case class Person(name: String, age: Int)
  val gaurav = Person("gaurav",25)

  val greeting = gaurav match {
    case Person(n,a) if a < 21 => s"Hi my name is $n and i am $a years old and i can drink" // with gaurd
    case Person(n,a) => s"Hi my name is $n and i am $a years old "
    case _ => "I dont know who i am"
  }
  println(greeting)
  /**
   * 1. Cases are matched in order
   * 2. What if no cases match => MatchError
   * 3. type of PM expression => unified types of all the types of all the cases
   * 4. PM works very well with case classes
   * */

  //PM on sealed hierarchy
  sealed class Animal
  case class Dog(breed:String) extends Animal
  case class Parrot(greeting:String) extends Animal

  val animal:Animal = Dog("Terr Nova")
  animal match {
    case Dog(someBreed) => println("Matched a dog")
    case Parrot(someGreeting) => println("Cat ") // runs without this also but RTJ said it'll not comiple without it
  }

  //Match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  // why so much bother
  val isEvenCond = if(x % 2 == 0) true else false // why ?
  val isEvenNormal = x% 2 == 0

  /*
  * Exercises
      simple function uses PM
        takes Expr as parameter and returns human readable form of it
     Sum(Number(2), Number(3)) => 2 + 3
     Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
     Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
     Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
  * */
  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr,e2:Expr) extends Expr
  case class Prod(e1:Expr,e2:Expr) extends Expr

  def show(expr:Expr): String = expr match {
    case Number(n) => s"$n"
    case Sum(e1,e2) =>  show(e1) + "+" + show(e2)
    case Prod(e1 , e2) => {
      def maybeShowParanthesis(exp: Expr) = exp match {
        case Prod(_ , _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) +")"
      }
      maybeShowParanthesis(e1) + " * " + maybeShowParanthesis(e2)
    }
  }
  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Number(2), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))

}
