package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age:Int = 0) {
    def likes(movie: String) : Boolean = movie == favoriteMovie
    def +(person:Person):String = s"${person.name} wants to marry with ${this.name}"
    def +(nickName:String): Person = new Person(s"$name ($nickName)",favoriteMovie)
    def unary_! : String = s"$name , what the hack!"
    def unary_+ : Person = {
      println("age incrementor ")
      new Person(name, favoriteMovie, age+1)
    }
    def learn(arg:String): String = s"$name learns $arg"
    def learnScala = this learn "Scala"
    def isAlive: Boolean = true
    def apply(): String = s"hi, my name is $name and i like $favoriteMovie and my age is $age"
    def apply(times:Int): String = s"$name watched $favoriteMovie $times times"

  }


  val reshu = new Person("rishabh","tamasha")
  println(reshu.likes("tamasha"))
  println(reshu likes "tamasha")
  // infix notation or operator notation(syntactic sugar)

  // "operators" in scala
  val shivagni = new Person("Shivagni","Vivah")
  println(reshu + shivagni)  // here "hangOutWith" acts like an operator between two things
  println(reshu.+(shivagni))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS

  // Akka actors have ! and ? operators(these are the asked pattern or tail pattern btw asynchronous actors )

  //THIS STYLE OF WRITTING METHODS OF CALLING METHODS IN INFIX NOTATION IS CALLED SYNTACTIC SUGAR


  // PREFIX NOTATION (another form of syntactic sugar)=>
  /**
   * prefix noation is all about unary operations
   * */

  val x = -1 // here negative sign is an unary operator . and unary operators are also methods
  val y = 1.unary_- //both x and y are same things
  // unary_ prefix only works with - + ~  ! operators
  println(!reshu)
  println(reshu.unary_!) // same as !reshu

  // postfix notation
  /**
   * functions that do not receive any parameter
   * have the property that they can be used in a postfix notation
   * */

  println(shivagni.isAlive)
  println(shivagni isAlive)

  //apply
  println(reshu.apply())
  println(reshu())  // both are equivalent



  println(reshu(5))
  println(reshu())
  println((reshu + "THE GGG")())
  println((+reshu).age)
  println(reshu learn "spark")
  println(reshu learnScala)

  /**
   * 1. Overload the + operator
   * eg: mary + "the rockstar" => new Person "mary (the rockstar)"
   *
   * 2. Add an age to the Person class
   *    Add an unary + operator => new Person with age + 1
   *    +mary = mary with age incrementer
   *
   * 3. Add a learns Method in the Person class : receive string parameter and returns a sentence which says
   *    = "Mary learns Scala"
   *    Add a learnScala method with no parameters and calls the learn method with "Scala" as parameter
   *    -Use it in postfix notation
   *
   * 4. Overload the apply method
   *    mary.apply(2) => "Mary watched Inception 2 times"
   * */
}
