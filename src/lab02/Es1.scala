package lab02

object Es1 extends App:
  val parity: Int => String = n => n%2 match
    case 0 => "even"
    case _ => "odd"

  def parity2(n: Int): String = n match
    case n if n%2 == 0 => "even"
    case _ => "odd"

