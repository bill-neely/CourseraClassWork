package funsets

object Functions_Data_worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val half = new Rational(1, 2)                   //> half  : funsets.Rational = 1/2
  val twoFourths = new Rational(2, 4)             //> twoFourths  : funsets.Rational = 1/2
  val twoThirds = new Rational(2, 3)              //> twoThirds  : funsets.Rational = 2/3
  val two = new Rational(2)                       //> two  : funsets.Rational = 2/1

  (half + twoThirds)                              //> res0: funsets.Rational = 7/6
  -half                                           //> res1: funsets.Rational = 1/-2
  (half - twoThirds)                              //> res2: funsets.Rational = 1/-6
  (half * twoThirds)                              //> res3: funsets.Rational = 1/3
  (half / twoThirds)                              //> res4: funsets.Rational = 3/4
  (half == twoThirds)                             //> res5: Boolean = false
  (half == twoFourths)                            //> res6: Boolean = true
  (half < twoThirds)                              //> res7: Boolean = true
  (twoThirds < half)                              //> res8: Boolean = false
  (half.max(twoThirds))                           //> res9: funsets.Rational = 2/3
  (twoThirds.max(half))                           //> res10: funsets.Rational = 2/3

  val x = new Rational(1, 3)                      //> x  : funsets.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : funsets.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : funsets.Rational = 3/2
  x - y - z                                       //> res11: funsets.Rational = -79/42
  y + y                                           //> res12: funsets.Rational = 10/7

}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)

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

  def max(that: Rational) = if (this < that) that else this
}
  