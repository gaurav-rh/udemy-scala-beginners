package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal {
    def eat :Unit
  }
  //anonymous class
  val funnyAimanl = new Animal {
    override def eat: Unit = println("hahahahahahaha")
  }
  /**
   * class AnonymousClass$$anon$1 extends Animal {
   *   override def eat: Unit = println("hahahahahahaha")
   * }
   * val funnyAnimal:Animal = new AnonymousClass$$anon$1
   * */
  println(funnyAimanl.getClass)

  class Person(name:String) {
    def sayHi:Unit = println(s"hi my name is $name , how i can help")
  }

  val jim: Person = new Person("jim") {
    override def sayHi:Unit = println(s"hi my name is jim , how i be of service")
  }
}


