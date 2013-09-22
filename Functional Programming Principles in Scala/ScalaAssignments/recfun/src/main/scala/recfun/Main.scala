package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    def factorial(n: Long): Long = {
      def loop(acc: Long, n: Long): Long  =
        if (n <= 0) acc
        else loop(acc * n, n - 1)
      loop(1, n)
    }

    val row: Long = r.toLong
    val col: Long = c.toLong
    val result: Long = factorial(row) / (factorial(col) * factorial(row-col))
    result.toInt
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
