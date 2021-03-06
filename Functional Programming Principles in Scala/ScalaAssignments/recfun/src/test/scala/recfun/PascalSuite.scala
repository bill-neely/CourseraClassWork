package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal

  test("pascal: col=0,row=0") {
    assert(pascal(0, 0) === 1)
  }
  
  test("pascal: col=0,row=1") {
    assert(pascal(0, 1) === 1)
  }

  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  test("pascal: col=7,row=10") {
    assert(pascal(7, 10) === 120)
  }

  test("pascal: col=6,row=20") {
    assert(pascal(6, 20) === 38760)
  }
}
