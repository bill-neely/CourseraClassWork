
object Video3_1_Worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val t1 = new NonEmpty(1, Empty, Empty)          //> t1  : NonEmpty = {.1.}
  val t2 = t1 incl 7                              //> t2  : IntSet = {.1{.7.}}
  val t3 = t2 incl 9                              //> t3  : IntSet = {.1{.7{.9.}}}
  val t4 = t3 incl 5                              //> t4  : IntSet = {.1{{.5.}7{.9.}}}
 
  val ta = new NonEmpty(10, Empty, Empty)         //> ta  : NonEmpty = {.10.}
  val tb = ta incl 17                             //> tb  : IntSet = {.10{.17.}}
  val tc = tb incl 19                             //> tc  : IntSet = {.10{.17{.19.}}}
  val td = tc incl 15                             //> td  : IntSet = {.10{{.15.}17{.19.}}}

  val u1 = Empty union t4                         //> u1  : IntSet = {.1{{.5.}7{.9.}}}
  val u2 = u1 union td                            //> u2  : IntSet = {{{.1.}5{{.7.}9.}}10{{.15.}17{.19.}}}
  Empty union Empty                               //> res0: IntSet = .
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet) = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString = "{" + left.toString + elem + right.toString + "}"
}