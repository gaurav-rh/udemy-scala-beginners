package lectures.part2oop

object CaseClasses extends App{
  /**
   * case class is very useful for defining a class and the companion object and a lot of defaults in one go
   * */

  case class Person(name:String , age:Int)

  // class parameters are promoted to fields
  val jim = new Person("jim-boy",23)
 // println(jim.age)

  // sensible toString
  println(jim.toString)

  // equals and hashCode implemented out of the box
  val jin2 = new Person("jim-boy",23)
  println(jim == jin2)  // =>true

    // case classes have handy copy method
    val jim3 = jim.copy(age = 45)
    println(jim3)
    println(jim == jim3)

    // case classes have companion objects
    val thePerson = Person
    val mary = Person("mary",16) // so the companion object - apply method does same as constructor => no need for "new" keyword in case classes


    // case classes are serialisable which makes CCs specially useful when dealing with distributed system

    // case classes have extractor patterns == case classes can be used in PATTERN MATCHING

    case object India {
      def name : String = "republic of India"
    }
    /*
    *   case objects have same property as case classes
    * except they dont get companion objects because they are their own companion objects
    * */

}
