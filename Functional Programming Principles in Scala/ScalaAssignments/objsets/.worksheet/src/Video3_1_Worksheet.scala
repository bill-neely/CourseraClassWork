
object Video3_1_Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(43); 

  val t1 = new NonEmpty(1, Empty, Empty);System.out.println("""t1  : NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 7;System.out.println("""t2  : IntSet = """ + $show(t2 ));$skip(21); 
  val t3 = t2 incl 9;System.out.println("""t3  : IntSet = """ + $show(t3 ));$skip(21); 
  val t4 = t3 incl 5;System.out.println("""t4  : IntSet = """ + $show(t4 ));$skip(45); 
 
  val ta = new NonEmpty(10, Empty, Empty);System.out.println("""ta  : NonEmpty = """ + $show(ta ));$skip(22); 
  val tb = ta incl 17;System.out.println("""tb  : IntSet = """ + $show(tb ));$skip(22); 
  val tc = tb incl 19;System.out.println("""tc  : IntSet = """ + $show(tc ));$skip(22); 
  val td = tc incl 15;System.out.println("""td  : IntSet = """ + $show(td ));$skip(28); 

  val u1 = Empty union t4;System.out.println("""u1  : IntSet = """ + $show(u1 ));$skip(23); 
  val u2 = u1 union td;System.out.println("""u2  : IntSet = """ + $show(u2 ));$skip(20); val res$0 = 
  Empty union Empty;System.out.println("""res0: IntSet = """ + $show(res$0))}
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
