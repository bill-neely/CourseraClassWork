package greeter

object Worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val x = 1                                       //> x  : Int = 1
  val y = x + 1                                   //> y  : Int = 2
  y + y                                           //> res0: Int = 4

  y +
    y                                             //> res1: Int = 4

  (y +
    y)                                            //> res2: Int = 4
    
  def abs(x: Double) = if (x <= 0) -x else x      //> abs: (x: Double)Double

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double = (
      if (isGoodEnough(guess)) guess
      else sqrtIter(improveGuess(guess)))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < .000000000001

    def improveGuess(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res3: Double = 1.414213562373095
  sqrt(4)                                         //> res4: Double = 2.000000000000002
  sqrt(1e-6)                                      //> res5: Double = 0.0010000000000000117
  sqrt(1e60)                                      //> res6: Double = 1.0E30

}