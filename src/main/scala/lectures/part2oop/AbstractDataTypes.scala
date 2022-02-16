package lectures.part2oop

object AbstractDataTypes extends App{

  //abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }
  class Dog extends Animal {
    override val creatureType: String = "domestic k9"
    def eat: Unit = println("bho bho")
  }

  //traits -> ultimate abstract data type in scala
  trait Carnivor {
    def eat(animal : Animal): Unit
    val preferedMeal : String = "fresh meat"
  }
  trait ColdBlooded
  class Crocodile extends Animal with Carnivor with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
   def eat(animal: Animal):Unit = println(s"I'am croc and im aating ${animal.creatureType}")
  }
  val dog = new Dog()
  val croco = new Crocodile()
  //croco.eat(dog)
  croco eat dog
  /**
    Traits vs Abstract classes
      both abstract classes and trait-->  can gave abstract and non-abstract members
      but
      1.traits can not have constructor parameters
      2.you can extend only one class but multiple traits
      3.traits = behaviour , abstract class = thing(type of thing)
  */

}
