package lectures.part2oop

import lectures.part2oop
import lectures.part2oop.{SPEED_OF_LIGHT, sayHello}
//import lectures.part3fp.{SPEED_OF_LIGHT, sayHello}
import playground.{PrinceCharming, Cinderella as Princess}

import java.util.Date
import java.sql.Date as SqlDate

object PackagingAndImports extends App{
  /**
   * package is basically a bunch of definitions grouped under the same name
   * 99% of time this matches directory structure
   * */

  // package members are accessable by their simple name

  val writer = new Writer("gaurav","raj",1996)

  // if not in package need to import the package
  val pricess = new Princess // if no import, compiler will not found Cinderella
  //or
  val queen = new playground.Cinderella // if no import ==>fully qualified class name


  //packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new playground.PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
