package greeter

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(14); 

  val x = 1;System.out.println("""x  : Int = """ + $show(x ));$skip(16); 
  val y = x + 1;System.out.println("""y  : Int = """ + $show(y ));$skip(8); val res$0 = 
  y + y;System.out.println("""res0: Int = """ + $show(res$0));$skip(14); val res$1 = 

  y +
    y;System.out.println("""res1: Int = """ + $show(res$1));$skip(16); val res$2 = 

  (y +
    y);System.out.println("""res2: Int = """ + $show(res$2));$skip(51); 
    
  def abs(x: Double) = if (x <= 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(351); 

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double = (
      if (isGoodEnough(guess)) guess
      else sqrtIter(improveGuess(guess)))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < .000000000001

    def improveGuess(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$3 = 

  sqrt(2);System.out.println("""res3: Double = """ + $show(res$3));$skip(10); val res$4 = 
  sqrt(4);System.out.println("""res4: Double = """ + $show(res$4))}

}
