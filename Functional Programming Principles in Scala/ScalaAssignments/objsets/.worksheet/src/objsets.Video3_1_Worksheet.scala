package objsets

object Video3_1_Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  println("Welcome to the Scala worksheet");$skip(49); 
  
  val t1 = new NonEmpty(3 , MyEmpty, MyEmpty);System.out.println("""t1  : objsets.Video3_1_Worksheet.NonEmpty = """ + $show(t1 ))}
  
  class MyEmpty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, new MyEmpty, new MyEmpty)
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
  }
  
  
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}
