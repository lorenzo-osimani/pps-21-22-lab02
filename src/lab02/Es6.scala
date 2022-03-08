package lab02

object Es6 extends App:
  def fib(n: Int): Int =
    @annotation.tailrec
    def fibIteration(n: Int, current: Int, next: Int): Int = n match
      case 0 => current
      case _ => fibIteration(n - 1, next, current + next)
    fibIteration(n, 0, 1)
