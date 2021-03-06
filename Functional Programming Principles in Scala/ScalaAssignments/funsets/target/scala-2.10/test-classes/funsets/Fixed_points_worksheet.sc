package funsets
import math.abs

object Fixed_points_worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstguess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstguess)
  }                                               //> fixedPoint: (f: Double => Double)(firstguess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> res0: Double = 1.999755859375
  fixedPoint(x => x * x - 3 * x + 4)(1)           //> res1: Double = 2.0

  def sqrt1(x: Double): Double =
    fixedPoint(y => (y + x / y) / 2)(1.0)         //> sqrt1: (x: Double)Double
  sqrt1(9)                                        //> res2: Double = 3.000000001396984

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double

  def sqrt(x: Double): Double =
    fixedPoint(averageDamp(y => x / y))(1.0)      //> sqrt: (x: Double)Double
  sqrt(9)                                         //> res3: Double = 3.000000001396984
}