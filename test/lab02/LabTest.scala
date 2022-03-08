package lab02

import org.junit.Assert.*
import org.junit.Test
import u02.BTrees.Tree.count

class LabTest:

  def parityCheck(f: Int => String) =
    assertEquals("odd", f(3))
    assertEquals("even", f(4))

  @Test def parity() =
    parityCheck(lab02.Es1.parity)
    parityCheck(lab02.Es1.parity2)

  def genericNegationCheck[A](negFunction: (A => Boolean) => (A => Boolean), predicate: A => Boolean, trueResult: A, falseResult: A) =
    val negatedPredicate = negFunction(predicate)
    assertTrue(negatedPredicate(trueResult))
    assertFalse(negatedPredicate(falseResult))
    assertTrue(negatedPredicate(trueResult) && !negatedPredicate(falseResult))

  @Test def testStringNegation() =
    val empty: String => Boolean = _ == ""
    genericNegationCheck(lab02.Es2.neg, empty, "empty", "")
    genericNegationCheck(lab02.Es2.neg2, empty, "empty", "")

  @Test def testGenericNegation() =
    val positive: Int => Boolean = _ >= 0
    genericNegationCheck(lab02.Es3.genericNeg[Int], positive, -5, 3)

  def notCurryingCheck(function: (Int, Int, Int) => Boolean) =
    assertTrue(function(3, 4, 5))
    assertFalse(function(4, 5, 3))

  def curryingCheck(function: Int => Int => Int => Boolean) =
    assertTrue(function(3)(4)(5))
    assertFalse(function(2)(4)(3))

  @Test def testCurrying() =
    curryingCheck(lab02.Es4.p1)
    notCurryingCheck(lab02.Es4.p2)
    curryingCheck(lab02.Es4.p3)
    notCurryingCheck(lab02.Es4.p4)

  @Test def testCompose() =
    assertEquals(9, lab02.Es5.compose(_ - 1)(_ * 2)(5))
    val f: Boolean => String = x => x match
      case true => "positivo"
      case _ => "negativo"
    assertEquals("positivo", lab02.Es5.genericCompose[Int, Boolean, String](f)(_ > 0)(5))
    assertEquals("negativo", lab02.Es5.genericCompose[Int, Boolean, String](f)(_ > 0)(-3))

