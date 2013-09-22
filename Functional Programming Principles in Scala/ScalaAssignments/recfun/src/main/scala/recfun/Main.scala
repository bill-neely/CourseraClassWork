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

    def sum(n: Int): Int = {
      if (n == 0) 0
      else n + sum(n - 1)
    }

    def cellAddr(row: Int, col: Int): Int =
      sum(row) + col

    def calcNextPTEntry(ptList: List[Int], row: Int, col: Int): Int =
      if (col == 0) 1
      else if (col == row) 1
      else ptList(cellAddr(row - 1, col - 1)) + ptList(cellAddr(row - 1, col))

    def nextRow(row: Int, col: Int): Int =
      if (row == col) row + 1
      else row

    def nextCol(row: Int, col: Int): Int =
      if (row == col) 0
      else col + 1

    def buildPT(row: Int, col: Int, ptList: List[Int], curRow: Int, curCol: Int): Int = {
      if (cellAddr(row, col) == cellAddr(curRow, curCol)) ptList(cellAddr(row, col))
      else buildPT(row,
        col,
        ptList ++ List(calcNextPTEntry(ptList, nextRow(curRow, curCol), nextCol(curRow, curCol))),
        nextRow(curRow, curCol),
        nextCol(curRow, curCol))
    }

    buildPT(r, c, List(1), 0, 0)

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
