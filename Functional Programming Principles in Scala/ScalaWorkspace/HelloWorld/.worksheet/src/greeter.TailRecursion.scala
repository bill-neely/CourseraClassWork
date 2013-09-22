package greeter
import scala.annotation.tailrec

object TailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(116); 
  println("Welcome to the Scala worksheet");$skip(72); 

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(16); val res$0 = 

  gcd(14, 21);System.out.println("""res0: Int = """ + $show(res$0));$skip(91); 

  def factorial_noTail(n: Int): Int =
    if (n == 0) 1 else n * factorial_noTail(n - 1);System.out.println("""factorial_noTail: (n: Int)Int""");$skip(151); 

  def factorial(n: Long): Long = {
    def loop(acc: Long, n: Long): Long =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  };System.out.println("""factorial: (n: Long)Long""");$skip(17); val res$1 = 

  factorial(5);System.out.println("""res1: Long = """ + $show(res$1));$skip(22); val res$2 = 
  factorial_noTail(4);System.out.println("""res2: Int = """ + $show(res$2))}
}
