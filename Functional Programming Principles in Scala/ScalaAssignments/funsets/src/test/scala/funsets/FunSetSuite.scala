package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("s1 contains 1") {
    new TestSets {
      assert(contains(s1, 1), "Singleton should contain 1")
    }
  }

  test("s1 does not contain 9") {
    new TestSets {
      assert(!(contains(s1, 9)), "Singleton should not contain 9")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val unionS1S2 = union(s1, s2)
      assert(contains(unionS1S2, 1), "Union 1")
      assert(contains(unionS1S2, 2), "Union 2")
      assert(!contains(unionS1S2, 3), "Union 3")
    }
  }

  test("intersect contains matching elements") {
    new TestSets {
      assert(contains(intersect(s1, s1), 1), "intersect s1,s1 contains 1")
      assert(contains(intersect(singletonSet(10), singletonSet(10)), 10), "intersect of 10's contains 10")
      assert(!contains(intersect(s1, s2), 1), "intersect s1,s2 does not contain 1")
      assert(!contains(intersect(s1, s2), 2), "intersect s1,s2 does not contain 2")
    }
  }

  test("diff contains differing elements") {
    new TestSets {
      assert(!contains(diff(s1, s1), 1), "diff s1,s1 does not contain 1")
      assert(contains(diff(s1, s2), 1), "diff s1,s2 contains 1")
      assert(!contains(diff(s1, s2), 2), "diff s1,s2 contains 2")
    }
  }

  test("diff{1,3,4,5,7,1000} and {1,2,3,4}) is 5, 7, 100") {
    def set1: Set = x => List(1, 3, 4, 5, 7, 1000).contains(x)
    def set2: Set = x => List(1, 2, 3, 4).contains(x)
    val theDiff = diff(set1, set2)
    assert(!contains(theDiff, 1), "does not contain 1")
    assert(!contains(theDiff, 2), "does not contain 2")
    assert(!contains(theDiff, 3), "does not contain 3")
    assert(!contains(theDiff, 4), "does not contain 4")
    assert(contains(theDiff, 5), "contain 5")
    assert(contains(theDiff, 7), "contain 7")
    assert(contains(theDiff, 1000), "contain 1000")
  }

  test("filter applies a predicate") {
    new TestSets {
      def greaterThan2(x: Int) = x > 2
      assert(!contains(filter(s1, greaterThan2), 1), "filter(s1,greaterThan2) does not contain 1")
      assert(!contains(filter(s2, greaterThan2), 2), "filter(s2,greaterThan2) does not contain 2")
      assert(contains(filter(s3, greaterThan2), 3), "filter(s3,greaterThan2) contains 3")
      assert(!contains(filter(s3, greaterThan2), 4), "filter(s3,greaterThan2) does not contains 4")
    }
  }

  test("forall checks all elem meet criteria < 5") {
    val s1 = x => List(1, 2, 3, 4).contains(x)
    assert(forall(s1, x => x < 5), "(1,2,3,4) are all strictly less than 5")
  }

  test("forall checks all elem meet criteria > 50") {
    val s1 = x => List(51, 52, 53, 54).contains(x)
    assert(forall(s1, x => x > 50), "(51,52,53,54) are all strictly greather than 50")
  }

  test("forall not all elem are < 5") {
    val s1 = x => List(1, 2, 3, 4, 5, 7, 1000).contains(x)
    assert(!forall(s1, x => x < 5), "(1,2,3,4,5,7,1000) are all strictly less than 5")
  }

  def even2to40: Set = x => (x >= 2) && (x <= 40) && (x % 2 == 0)
  test("20 exists in even2to40") {
    assert(exists(even2to40, x => x == 20))
  }

  test("no odd number exists in even2to40") {
    assert(!exists(even2to40, x => x % 2 != 0))
  }

  test("simple map to negate set") {
    val negSingleton = map(singletonSet(2), x => -x)
    assert(contains(negSingleton, -2), "negated set should contain -2")
  }

  test("evens and 3 - from grader - contains") {
    val evensAnd3: Set = x => x % 2 == 0 || x == 3
    assert(contains(evensAnd3, 3))
  }

  test("evens and 3 - from grader - filter") {
    val evensAnd3: Set = x => x % 2 == 0 || x == 3
    assert(FunSets.toString(filter(evensAnd3, x => x == 3)) === "{3}")
  }

  test("evens and 3 - from grader - exists") {
    val evensAnd3: Set = x => x % 2 == 0 || x == 3
    assert(exists(evensAnd3, x => x == 3), "3 should exist")
  }

    test("map - doubler") {
    val premap = x => List(-2, 1, 3, 4).contains(x)
    val mapped = map(premap, x => x * 2)
    assert(FunSets.toString(mapped) === "{-4,2,6,8}")
  }
    
  test("map from grader") {
    val premap = x => List(1, 3, 4, 5, 7, 1000).contains(x)
    val mapped = map(premap, x => x - 1)
    assert(FunSets.toString(mapped) === "{0,2,3,4,6,999}")
  }
}
