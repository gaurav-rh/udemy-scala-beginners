package lectures.part2oop

object Objects extends App{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // its own type + it's only instance
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    //this method is called a factory method because its sole purpose is to build a persons(given some parameters)
    def apply(mother: Person, father: Person): Person = new Person("Lassie")
  }

  class Person(val name: String) {
    //Instance level functionality
  }

  /**
   * object and class with same name are called COMPANIONS
   * */
  println(Person.N_EYES)

  //So Objects can be defined in a similar way that classes can , with the exception that objects do not receive parameters
  // to use class level definition we use objects in scala


  /**
   * Scala object is a singleton instance.
   * Scala object = SINGLETON INSTANCE
   * */

    val mary = Person
    val john = Person
    println(mary == john)
    val person1 = new Person("reshi")
    val person2 = new Person("agni")
    println(person1 == person2)

    val bobbie = Person.from(person1, person2)
    val lassie = Person(person1, person2)


    // SCALA APPLICATIONS = Scala object with
    // def main(args: Array[String]): Unit

  }


/**
 * TAKEAWAYS
 * 1. SCALA DOESN"T HAVE "STATIC" VALUES/ METHODS
 * 2. SCALA OBJECTS
 *    ->are in their own class
 *    ->are the only instance
 *    ->singleton pattern in one line!
 * 3. SCALA COMPANIONS
 *    ->can access each other's private members
 *    ->scala is more OO than Java
 * 4. SCALA APPLICATIONS
 *    -> scala objects with "def main()" or something which extends "App"
 * */
