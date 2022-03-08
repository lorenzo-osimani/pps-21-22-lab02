package lab02

object Es5 extends App:
  def compose(f: Int => Int)(g: Int => Int): Int => Int = x => f(g(x))
  
  def genericCompose[A, B, C](f: B => C)(g: A => B): A => C = x => f(g(x))
