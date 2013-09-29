package funsets

object funsets_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 
  println("Welcome to the Scala worksheet");$skip(301); 

  /**
   * *  def sum(f: Int => Int)(a: Int, b: Int): Int = {
   * def loop(a: Int, acc: Int): Int = {
   * if (a > b) acc
   * else loop(a + 1, acc + f(a))
   * }
   * loop(a, 0)
   * }
   */

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f)(a + 1, b)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(22); val res$0 = 

  sum(x => x)(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  sum(x => x)(8, 12);System.out.println("""res1: Int = """ + $show(res$1));$skip(24); val res$2 = 
  sum(x => x * x)(3, 5);System.out.println("""res2: Int = """ + $show(res$2));$skip(114); 

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$3 = 

  product(x => x)(1, 5);System.out.println("""res3: Int = """ + $show(res$3));$skip(24); val res$4 = 
  product(x => x)(3, 5);System.out.println("""res4: Int = """ + $show(res$4));$skip(28); val res$5 = 
  product(x => x * x)(3, 4);System.out.println("""res5: Int = """ + $show(res$5));$skip(24); val res$6 = 
  product(x => x)(6, 5);System.out.println("""res6: Int = """ + $show(res$6));$skip(45); 

  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(12); val res$7 = 

  fact(4);System.out.println("""res7: Int = """ + $show(res$7));$skip(11); val res$8 = 
  fact(10);System.out.println("""res8: Int = """ + $show(res$8));$skip(188); 
  
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    };System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(95); 
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(32); val res$9 = 
  
    
  product(x => x)(1, 5);System.out.println("""res9: Int = """ + $show(res$9));$skip(25); val res$10 = 
  product2(x => x)(1, 5);System.out.println("""res10: Int = """ + $show(res$10));$skip(27); val res$11 = 
  
  product(x => x)(3, 5);System.out.println("""res11: Int = """ + $show(res$11));$skip(28); val res$12 = 
  product(x => x * x)(3, 4);System.out.println("""res12: Int = """ + $show(res$12));$skip(24); val res$13 = 
  product(x => x)(6, 5);System.out.println("""res13: Int = """ + $show(res$13))}
  
  
  
  
  
  
  
  
}
