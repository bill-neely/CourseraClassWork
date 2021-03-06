package funsets

object funsets_worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x)(1, 4)                               //> res0: Int = 10
  sum(x => x)(8, 12)                              //> res1: Int = 50
  sum(x => x * x)(3, 5)                           //> res2: Int = 50

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x)(1, 5)                           //> res3: Int = 120
  product(x => x)(3, 5)                           //> res4: Int = 60
  product(x => x * x)(3, 4)                       //> res5: Int = 144
  product(x => x)(6, 5)                           //> res6: Int = 1

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int

  fact(4)                                         //> res7: Int = 24
  fact(10)                                        //> res8: Int = 3628800
  
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    }                                             //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  
  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  
    
  product(x => x)(1, 5)                           //> res9: Int = 120
  product2(x => x)(1, 5)                          //> res10: Int = 120
  
  product(x => x)(3, 5)                           //> res11: Int = 60
  product(x => x * x)(3, 4)                       //> res12: Int = 144
  product(x => x)(6, 5)                           //> res13: Int = 1
  
  
  
  
  
  
  
  
}