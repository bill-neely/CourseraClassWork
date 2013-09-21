package greeter
import scala.annotation.tailrec

object TailRecursion {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  gcd(14, 21)                                     //> res0: Int = 7

  def factorial_noTail(n: Int): Int =
    if (n == 0) 1 else n * factorial_noTail(n - 1)//> factorial_noTail: (n: Int)Int

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(4)                                    //> res1: Int = 24
  factorial_noTail(4)                             //> res2: Int = 24
}