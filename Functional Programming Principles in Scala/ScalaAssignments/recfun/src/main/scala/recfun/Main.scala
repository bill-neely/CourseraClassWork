package recfun
import common._

object Main {
  def main(args: Array[String]) {
    val start = System.nanoTime
    println("Pascal's Triangle")
    for (row <- 0 to 30) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("Duration: " + ((System.nanoTime - start) / 1000000000.0))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def countDepth(depth: Int, chars: List[Char]): Int =
      if (chars.isEmpty) depth
      else if (depth < 0) depth
      else if (chars.head == '(') countDepth(depth + 1, chars.tail)
      else if (chars.head == ')') countDepth(depth - 1, chars.tail)
      else countDepth(depth, chars.tail)

    countDepth(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)

}
