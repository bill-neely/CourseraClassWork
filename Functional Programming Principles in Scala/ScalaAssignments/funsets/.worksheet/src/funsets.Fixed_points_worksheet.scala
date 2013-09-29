package funsets
import math.abs

object Fixed_points_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  println("Welcome to the Scala worksheet");$skip(27); 

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(235); 

  def fixedPoint(f: Double => Double)(firstguess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstguess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstguess: Double)Double""");$skip(34); val res$0 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(40); val res$1 = 
  fixedPoint(x => x * x - 3 * x + 4)(1);System.out.println("""res1: Double = """ + $show(res$1));$skip(77); 

  def sqrt1(x: Double): Double =
    fixedPoint(y => (y + x / y) / 2)(1.0);System.out.println("""sqrt1: (x: Double)Double""");$skip(11); val res$2 = 
  sqrt1(9);System.out.println("""res2: Double = """ + $show(res$2));$skip(69); 

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(79); 

  def sqrt(x: Double): Double =
    fixedPoint(averageDamp(y => x / y))(1.0);System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$3 = 
  sqrt(9);System.out.println("""res3: Double = """ + $show(res$3))}
}
