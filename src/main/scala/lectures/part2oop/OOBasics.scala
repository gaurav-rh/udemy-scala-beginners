package lectures.part2oop

object OOBasics extends App {
  val person = new Person("john", 26)
  println(person.x)
  person.greet("Danial")

  val author = new Writer("Prakhar", "singh", 1997)
  val jaypee = new Writer("Prakhar", "singh", 1997)

  val novel = new Novel("bahut accha dost", 2014, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))


  val counter = new Counter()
  counter.counterIncrementOperation().print
  counter.counterIncrementOperation().counterIncrementOperation().counterIncrementOperation().print
  counter.counterIncrementOperation(10).print
}
  //constructor
  class Person(name: String, val age: Int) {
    //body
    val x = 2

    println(1 + 3)

    //method
    def greet(name: String): Unit = println(s"${this.name} says hi , $name")

    //overloading
    def greet(): Unit = println(s"hi my name is $name")

    //multiple constructors
    def this(name: String) = this(name, 0)

    /*
  * the implementation of secondary construction must be another constructor and nothing else
  */
    def this() = this("Gaurav")
    /*
  * this limitation makes the auxiliary constructors quite impractical
  *  because they're only used in practice for default parameters to the actual class definition
  this can be more easily solved vy supplying a default parameter to the actual class definition
  therefore we won't actually need this auxiliary constructors
  * */

    //DEFAULT PARAMETERS WORKS FOR CONSTRUCTORS AS WELL
  }

  //class parameters are NOT FIELDS

  /*
  two classes Novel and a Writer
  Writer: first name, surname, yearOf Birth
    -method:full name(returns concatenation of first name and sir name)
  Novel: name , year of release , author
    - authorAge : age of author at the year of release
    - isWrittenBy(author)
    - copy(new year of release) = new instance of Novel with a new year of release
*/


  class Novel(name: String, yearOfRelease: Int, author: Writer) {

    def authorAge(): Int = yearOfRelease - author.year

    def isWrittenBy(author: Writer): Boolean = author == this.author

    def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
  }

  class Writer(firstName: String, surName: String, val year: Int) {
    def fullName(): String = firstName + " " + surName
  }

  /*
  Counter class
    -receive an Int value
    - method current count
    - method to increment/decrement the counter by one , but will return a new counter(=> new Counter)
    - overload inc/dec to receive a parameter which is the amount by which
      you inc/dec the counter and will return a new counter(=> new Counter)

*/

  class Counter(val value: Int = 0) {

    def currentCount(): Int = this.value

    def counterIncrementOperation(): Counter = {
      println("Incrementing")
      new Counter(value + 1) // immutibility
    }

    def counterDecrementOperation(): Counter = {
      println("Decrementing")
      new Counter(value - 1)
    }

    def counterIncrementOperation(timesOperation: Int): Counter = {
      if (timesOperation <= 0) this
      else counterIncrementOperation().counterIncrementOperation(timesOperation - 1)
    }

    def counterDecrementOperation(timesOperation: Int): Counter = {
      if (timesOperation <= 0) this
      else counterDecrementOperation().counterDecrementOperation(timesOperation - 1)
    }

    def print: Unit = println(value)


  }

  /**
* defining classes
Instantiating
parameters vs fields
defining methods
calling methods
keyword this
   */
