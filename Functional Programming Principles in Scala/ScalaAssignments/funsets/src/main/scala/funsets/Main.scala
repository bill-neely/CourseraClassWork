package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  println("")
  println("map: {1,3,4,5,7,1000} = {0,2,3,4,6,999}")
  val premap = x => List(1, 3, 4, 5, 7, 1000).contains(x)
  val mapped: Set = map(premap, x => x - 1)
  printSet(premap)
  printSet(mapped)
  println("Should be {0,2,3,4,6,999} and is " + FunSets.toString(mapped))

}
