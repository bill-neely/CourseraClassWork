package funsets
import math.abs

object Functions_Data_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(111); 
  println("Welcome to the Scala worksheet");$skip(34); 

  val half = new Rational(1, 2);System.out.println("""half  : funsets.Rational = """ + $show(half ));$skip(38); 
  val twoFourths = new Rational(2, 4);System.out.println("""twoFourths  : funsets.Rational = """ + $show(twoFourths ));$skip(37); 
  val twoThirds = new Rational(2, 3);System.out.println("""twoThirds  : funsets.Rational = """ + $show(twoThirds ));$skip(28); 
  val two = new Rational(2);System.out.println("""two  : funsets.Rational = """ + $show(two ));$skip(30); 
  val n = new Rational(-1, 6);System.out.println("""n  : funsets.Rational = """ + $show(n ));$skip(23); val res$0 = 
  
  half.+(twoThirds);System.out.println("""res0: funsets.Rational = """ + $show(res$0));$skip(21); val res$1 = 
  (half + twoThirds);System.out.println("""res1: funsets.Rational = """ + $show(res$1));$skip(8); val res$2 = 
  -half;System.out.println("""res2: funsets.Rational = """ + $show(res$2));$skip(21); val res$3 = 
  (half - twoThirds);System.out.println("""res3: funsets.Rational = """ + $show(res$3));$skip(21); val res$4 = 
  (half * twoThirds);System.out.println("""res4: funsets.Rational = """ + $show(res$4));$skip(21); val res$5 = 
  (half / twoThirds);System.out.println("""res5: funsets.Rational = """ + $show(res$5));$skip(22); val res$6 = 
  (half == twoThirds);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(22); val res$7 = 
  (half != twoThirds);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(23); val res$8 = 
  (half == twoFourths);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(23); val res$9 = 
  (half != twoFourths);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(21); val res$10 = 
  (half < twoThirds);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(21); val res$11 = 
  (twoThirds < half);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(24); val res$12 = 
  (half.max(twoThirds));System.out.println("""res12: funsets.Rational = """ + $show(res$12));$skip(24); val res$13 = 
  (twoThirds.max(half));System.out.println("""res13: funsets.Rational = """ + $show(res$13));$skip(31); 

  val x = new Rational(1, 3);System.out.println("""x  : funsets.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : funsets.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : funsets.Rational = """ + $show(z ));$skip(12); val res$14 = 
  x - y - z;System.out.println("""res14: funsets.Rational = """ + $show(res$14));$skip(8); val res$15 = 
  y + y;System.out.println("""res15: funsets.Rational = """ + $show(res$15))}

}
 
class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x / abs(gcd(x, y))
  def denom = y / abs(gcd(x, y))

  override def toString = numer + "/" + denom

  def unary_- : Rational = new Rational(numer * -1, denom)

  def +(that: Rational) =
    new Rational(this.numer * that.denom + that.numer * this.denom, this.denom * that.denom)

  def -(that: Rational) =
    this + -that

  def *(that: Rational) =
    new Rational(this.numer * that.numer, this.denom * that.denom)

  def /(that: Rational) =
    new Rational(this.numer * that.denom, this.denom * that.numer)

  def <(that: Rational) =
    (this.numer * that.denom < that.numer * this.denom)

  def ==(that: Rational) =
    (this.numer * that.denom == this.denom * that.numer)
    
  def != (that: Rational) =
    !(this == that)

  def max(that: Rational) = if (this < that) that else this
}
  