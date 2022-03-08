package lab02

object Es3 extends App:
  def genericNeg[A](f: A => Boolean)(a: A) = !f(a)
