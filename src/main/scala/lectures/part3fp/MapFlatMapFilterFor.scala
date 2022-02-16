package lectures.part3fp

object MapFlatMapFilterFor extends App{

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ +1))
  println(list.map(_ +" is a number"))

  //filter
  println(list.filter(_ %2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x,x+1)
  println(list.flatMap(toPair))

  //print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  // List("a1","a2","a3","a4","b1"...."d4")
  //val toPairs = (li: List[Char], lis:List[Int]) => List(li.toString() + lis)
  //println(numbers.flatMap(toPairs))
  val combinations = numbers.flatMap(n => chars.map(c => ""+c+n))
  println(combinations)
  val colors = List("Black","white")
  val combi = numbers.flatMap(n => chars.flatMap(ch => colors.map(col => ""+ch+n+"-"+col)))
  println(combi)


  //forComprehensions
  val forCombinations = for {
    n <- numbers if(n % 2 == 0) //numbers.filter(_%2==0).flatMap(n => chars.flatMap(ch => colors.map(col => ""+ch+n+"-"+col)))
    c <- chars
    col <- colors
  }yield ""+c+n+"-"+col

  // side Effect
  //Equivalent of forEach
  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x*2
  }

  /**
   * Exercises
   * 1.MyList supports for comprehension
   * 2.A small collection of at most One element -> Maybe[+T]
   *  -map , flatMap, filter
   * */
}
