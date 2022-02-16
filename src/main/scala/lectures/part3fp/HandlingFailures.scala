package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailures extends App{

  //creates success or failure
  val aSuccess = Success(30)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String")

  //Try objects with apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //syntax sugar
  val anotherPotentialFailure = Try {
    // code that my throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupmethod(): String = "A valid result"
  val fallBackTry =  Try(unsafeMethod()).orElse(Try(backupmethod()))
  println(fallBackTry)

  //If you design an API (wrap the computation in Try)
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException) // wrap in Failure if you that that will throw an exception
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallbackTry = betterUnsafeMethod() orElse betterBackupMethod()

  //map , flatMap , filter
  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 100))

  //for comprehensions

  /*
  Exercise
  * */
  val host = "localhost"
  val port = "8080"

  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection Inturrepted")
    }

    def safeGet(url :String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Ome one took the port")
    }

    def getSafeConnection(host:String, port:String): Try[Connection] = Try(getConnection(host,port))
  }
  // if you get the html page from connection print it to consol ; call renderHTML

  val possibleConnection = HttpService.getSafeConnection(host,port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.safeGet("/home"))
  possibleHTML.foreach(renderHTML)

  //sorthand version
  HttpService.getSafeConnection(host,port)
    .flatMap(connection => connection.safeGet("/home"))
    .foreach(renderHTML)

  // for comprehension version
  for {
    connection <- HttpService.getSafeConnection(host,port)
    htmlPage <- connection.safeGet("/home")
  } yield renderHTML(htmlPage)

  //inperitive language
 /* Try {
    val connections = HttpService.getSafeConnection(host,port)
    Try {
      page = connections.get("/home")
      renderHTML(page)
    } catch(some othe exception) {

    }
  } catch (exception) {

  }*/
}
