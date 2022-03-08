package lab02

object Es4 extends App:

  val predicate: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y <= z

  val p1: Int => Int => Int => Boolean = x => y => z => predicate(x, y, z)
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => predicate(x, y, z)
  def p3 (x: Int)(y: Int)(z: Int): Boolean = predicate(x, y, z)
  def p4 (x: Int,y: Int,z: Int): Boolean = predicate(x, y, z)
