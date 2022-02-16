package lectures.part2oop

object Inheritance extends App {

  //single class inheritance
  class Animal {
    def eat = println("nomnom")
    val creatureType = "creature Type"
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  // a subclass only inherits non-private members of super class
  // protected will only work inside that sub-class

  //Constructors

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0) // after this "extends Person(name)" is also valid
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // need to provide parameters to Person here otherwise compilation error
  //correct way to extend class is with parameters


  //overriding

  class Dog(dogType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch crunch")
    }

    override val creatureType: String = dogType
  }
  val dog = new Dog("domestic")

  dog.eat
  println(dog.creatureType)


  // TYPE SUBSTITUTION (broad:Polymorphism)
  val unknownAnimal:Animal = new Dog("k9")
  unknownAnimal.eat // most overridden version of method will be called

 // val unknownWildAnimal:Dog = new Animal()


 //overRIDING vS OverLOADING

 //super

 // preventing override
 /**
  * 1. use final on member
  * 2.use final on the entire class
  * 3. seal the class
  *   sealing the class is a softer restriction in that you can extend classes in this(same) file
  *   but prevents extension in other files
  *   keywoed "sealed"
  * */
}