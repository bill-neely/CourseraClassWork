import scala.annotation.tailrec
package greeter

object TailRecursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(115); 
  println("Welcome to the Scala worksheet");$skip(71); 

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(16); val res$0 = 

  gcd(14, 21)


  @tailrec;System.out.println("""res0: Int = """ + $show(res$0));$skip(89); 
  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(20); val res$1 = 

  factorial(20000);System.out.println("""res1: Int = """ + $show(res$1))}
}
