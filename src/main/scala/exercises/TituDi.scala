package exercises


def add_(int:Int) :Int = int + int
val value = add_
def divi(int:Int) :Int = int/2
val dd = divi _
object TituDi extends App{
  //println(add(2))
  println(List(1,2,3).map(value))
  println(List(2,4,6).map(dd))
}
