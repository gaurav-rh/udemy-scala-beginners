package lectures.part3fp

//import lectures.part3fp.Options.{Connection, Connections}

import java.sql
import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // Options were invented to deal with unsafe API's

  def unsafeMethod(): String = null

  //val result = Some(unsafeMethod()) //WRONG
  val result = Option(unsafeMethod()) // apply method of Option
  // will take care to build Some or None depending on value
  println(result)
  /*
  * so the whole point of Option is we should never do Null checks ourselves
  The Option() type will take care for us
  * */

  // way to use Options will be in
  // chained methods

  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  //DESIGN unsafe API's
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  //Functions on Options
  println(myFirstOption.isEmpty)
  println(noOption.isDefined)
  println(noOption.isEmpty)
  println(myFirstOption.get) //Unsafe its like trying to access a null pointer => Do not use this
  // in case option is null get method will fetch nullPointerException


  //map , flatmap , filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //For comprehensions

  val config: Map[String, String] = Map {
    //fetched from somewhere else not sure that key contains value
    "host" -> "196.45.36.1"
    "port" -> "80"
  }

  class Connections {
    def connect(): String = "Connected" // just connect to some server
  }

  object Connections {
    val randomNumberGenerator = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connections] =
      if (randomNumberGenerator.nextBoolean()) Some(new Connections)
      else None
  }

  /* val connector = new Connections // (config.keys.toList.head , config.values.head)
   if( connector.apply(config.keys.toList.head , config.values.head) != None) connector.connect()
   //try to establish a connection --if so , print the connect method
 */
  val host = config.get("host")
  val port = config.get("port")
  /*
  * if(h != null)
      if(p != null)
        Connections.apply(h,p)
  * */
  val connection = host.flatMap(h => port.flatMap(p => Connections.apply(h, p)))
  /*
  * if(c != null)
      return c.connect()
    return null
  * */
  val connectionStatus = connection.map(c => c.connect())
  //if(connectionStatus = null) println(None) else println(connectionStatus.get)
  println(connectionStatus)
  /*
  * if(status != null)
      println(status)

  * */
  connectionStatus.foreach(println)

  //chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connections(host, port))
      .map(connection => connection.connect()))
    .foreach(println)

  //for comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connections(host,port)
  } yield connection.connect()
  forConnectionStatus.foreach(println)
}
