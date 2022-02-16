package lectures.part2oop

object OoExercises extends App{
  /**
   * 1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
   * Generic trait Mytransformer[-A,B] with a method transform(A) => B
   * MyList:
   *  -map(transformer) => Mylist
   *  -filter(predicate) => Mylist
   *  -flatMap(transformer from A to MyList[B]) => Mylist[B]
   *
   *  eg. [1,2,3].map(n*2) = [2,4,6]
   *    [1,2,3,4].filter(n%2) = [2,4]
   *    [1,2,3].flatMap(n => [n,n+1]) => [1,2,2,3,3,4]
   * */
  trait Mypredicate[-T] {
    def test(element: T):Boolean
  }
  trait Mytransformer[-A,B] {
    def transform(a:A): B
  }

}
