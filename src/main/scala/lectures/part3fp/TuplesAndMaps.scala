package lectures.part3fp

object TuplesAndMaps extends App {

  //tuples = finite ordered kind of like "Lists"
  val aTuple = new Tuple2(2, "Hello Scala") //Tuple2[Int, String] = (Int, String)
  // aTuple = Tuple(2, "Hello Scala")
  // aTuple = (2 ,"Hello Scala)"
  /**
   * Tuples can group atmost 22 elements of different types
   * 22 because they are in conjunction with Function types
   * */
  println(aTuple._1)
  println(aTuple.copy(_2 = "bye java"))
  println(aTuple.swap) // swaps the element in place


  //Maps -keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("gaurav" -> 777), ("JIM" -> 666)).withDefaultValue(-1)
  // a->b is sugar for (a,b)
  println(phoneBook)

  //map operations
  // println(phoneBook.contains("gaurav"))
  //println(phoneBook("gaurav"))
  //println(phoneBook("prakhar"))

  //add a pairing
  val aNewpairing = "Mary" -> 687
  val newPhoneBook = phoneBook + aNewpairing
  //println(newPhoneBook)

  //functionals on mapa
  // map , flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys
  //println(phoneBook.filterKeys(x => x.startsWith("J")))

  //mapValues
  println(phoneBook.mapValues(number => "+91-" + number))

  //conversions to some other collections
  println(phoneBook.toList)
  println(List(("Gaurav", 9450)).toMap)
  val names = List("Prakhar", "Rishabh", "Mohnu", "Bhavya", "Parth", "Garima")
  println(names.groupBy(name => name.charAt(0)))

  /**
   * 1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
   * !!! careful with mapping keys.
   * 2.  Overly simplified social network based on maps
   * Person = String
   * - add a person to the network
   * - remove
   * - friend (mutual)
   * - unfriend
   * - number of friends of a person
   * - person with most friends
   * - how many people have NO friends
   * - if there is a social connection between two people (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriends(networkAcc, person, friends.head))

    val unFriended = removeAux(network(person), network)
    unFriended - person
  }

  def unFriends(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)

    network + (personA -> (friendA - personB)) + (personB -> (friendB - personA))
  }

  def friends(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendA = network(personA)
    val friendB = network(personB)

    network + (personA -> (friendA + personB)) + (personB -> (friendB + personA))
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Gaurav"), "Prakhar")
  println(network)
  println(friends(network, "Gaurav", "Prakhar"))
  println(unFriends(network, "Gaurav", "Prakhar"))
  println(remove(friends(network, "Gaurav", "Prakhar"), "Gaurav"))

  //Gaurav,Prakhar,Sikha
  val people = add(add(add(empty, "Gaurav"), "Prakhar"), "Sikha")
  val gauravPrakhar = friends(people, "Gaurav", "Prakhar")
  val testSikha = friends(gauravPrakhar, "Prakhar", "Sikha")
  val test = add(testSikha,"Reshu")

  println(testSikha)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testSikha, "Prakhar"))

  def personWithMostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println(personWithMostFriends(testSikha))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(_._2.size == 0)

  }
  println(nPeopleWithNoFriends(test))

  def socialConnection(network: Map[String, Set[String]],personA:String, personB:String): Boolean = {
    def bfs(target: String, consideredPeople:Set[String], discoveredPeopele:Set[String]): Boolean ={
      if(discoveredPeopele.isEmpty) false
      else {
        val person = discoveredPeopele.head
        if(person == target) true
        else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeopele.tail)
        else bfs(target, consideredPeople + person ,discoveredPeopele.tail ++ network(person))
      }
    }
    bfs(personB,Set(),network(personA)+personA)
  }
  println(socialConnection(testSikha,"Gaurav","Sikha"))
  println(socialConnection(network,"Gaurav","Prakhar"))
  println(socialConnection(test,"Reshu","Sikha"))
}
