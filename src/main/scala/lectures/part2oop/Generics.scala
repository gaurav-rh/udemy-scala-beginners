package lectures.part2oop

object Generics extends App {
  /**
   * Generic classes and traits
   * */
  /* class MyList[A] { // A is type parameter
     //traits can also be type parameterised
     //use type A
   } */
  class MyList[+A] { //
    // def add(element:A): MyList[A] = ??? error:covariant type A occurs in contravariant position in type A of parameter element
    def add[B >: A](element: B): MyList[B] = ??? //new parameter B which is supertype of A


    /**
     * EXERCISE
     * Expand MyList to be Generic
     * */
  }

  //multiple type parameter is also there
  class MyMap[Keys, Values] {

  }

  val listOfInteger = new MyList[Int]
  val listOfString = new MyList[String]


  /**
   * Generic Methods
   * */
  object MyList { //companion object of class MyList
    //Objects cannot be type parameterised
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  /**
   * Variance Problem
   * */
  class Animal

  class Dog extends Animal

  class Cat extends Animal

  // if a dog extends animal does a List[Dog] extends List[Animal]
  // Ans 1 == yes List[Dog] extends List[Animal] ==> this behaviour is called COVARIANCE
  // THE WAY YOU DECLARE A COVARIANCE LIST
  class CovariantList[+A] // + here means its a covariance list

  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? HARD QUESTION :: => will turn this list into list of animals

  // Ans  == No List[Cat] and List[Animal] are two separate things ==> this is called INVARIANCE
  class InvariantList[A] //without any signs before and after
  // val anInvariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  //cannot do the above line

  // Ans 3 == Hell No , CONTRAVARIANCE
  class ContraVariantList[-A]

  val contraVariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  /**
   * the above line does'nt make sense atleast for list because how can we replace Animal with cat
   * because animal can be Any animal
   * opposite of this in Covariance is Okay
   * but
   * */
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  /**
   * this above code make sense
   * because a animal trainer can also train a cat
   * actuall its more better
   * */

  /**
   * BOUNDED TYPES
   * allows you to use generic classes only for certain type
   * that are either subclass of different type or super class of a different type
   * eg:
   * */

  class Cage[A >: Animal](animal: A) // class cage can only accept type parameters A which are subtypes of Animal

  val cage = new Cage(new Dog)

  class Car

  val newCage = new Cage(new Car)
  //val newCage = new Cage(new Car) this is not acceptable
  //above generic type need proper bounded type
  println(newCage)

  class Cages[A >: Animal](animal: A) //only accept supertype of animal

  /**
   * Bounded types solve a variance problem => hard when we try to write covariance collections
   * */
}
