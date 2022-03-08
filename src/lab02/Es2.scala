package lab02

object Es2 extends App:
  val neg: (String => Boolean) => (String => Boolean) =
    f => s => !f(s)

  def neg2(f: String => Boolean)(s: String) = !f(s)
