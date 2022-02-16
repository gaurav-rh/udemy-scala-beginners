package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  //Seq ==> sequences
   val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) //==> that means a sequence with apply method with get
  //aSequence.get at index 2
  println(aSequence ++ Seq(5,6,7)) // ++ is for concatination
  println(aSequence.sorted)

  //Ranges (which are also Sequences)
  val aRange:Seq[Int] = 1 to 10
  aRange.foreach(println)
  println(aRange)

  //until with right end non inclusive
  val bRange = 1 until 10
  bRange.foreach(println)
  println(bRange)

  (1 to 10).foreach(x => println("Hello"))

  //lists
  val aList = List(1,2,3)
  val aPrepended = 42 :: aList
  println(aPrepended)

  val bPrepended = 42 +: aList :+ 89

  val apple5 = List.fill(5)("apple")  // fill is a curried function
  println(apple5)
  println(aList.mkString("-|-"))

  /**
   * Arrays
   * */
  val numbers = Array(1,2,3,4)
  val threeNumbers = Array.ofDim[Int](3)
  threeNumbers.foreach(println) // Arrays have default values 0 for int and "Null" for Strings

  //mutation
  numbers(2) = 0 // syntax suger for numbers.upadate(2,0)
  println(numbers.mkString("-"))

  // arrays and sequences
  val numberSeq: Seq[Int] = numbers //Implicit conversion
  println(numberSeq)

  //Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //Vectors vs Lists

  val maxRun = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double ={
    val randomNumberGenerator = Random

    val times = for {
      it <- 1 to maxRun
    } yield {
      val currentTime = System.nanoTime()
      //operation
      collection.updated(randomNumberGenerator.nextInt(maxCapacity),randomNumberGenerator.nextInt())
      System.nanoTime()-currentTime
    }

    times.sum * 1.0 / maxRun
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // advantage of List => keeps reference to tails
  //disadvantage => updating an element in the middle of the list takes a long time
  println(getWriteTime(numbersList))
  //advantage of Vector => depth of the tree is small
  //disadvantage => needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
  /**
   * Vector takes 5492.805
   * List takes 8424746.392 nano sec
      this is why Vectors are default Implimentation of Sequence
   * */
}
