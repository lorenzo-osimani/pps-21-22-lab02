package lab02

object Es8 extends App:
  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(predicate: A => Boolean) = flatMap(opt)(a => if (predicate(a)) then opt else None())

    def map[A, B](opt: Option[A])(function: A => B): Option[B] = flatMap(opt)(x => Some(function(x)))

    def map2[A, B, C](opt1: Option[A])(opt2: Option[B])(function: (A, B) => C) = (opt1, opt2) match
      case (Some(a), Some(b)) => Some(function(a, b))
      case _ => None()

  import Option.*

  println(filter(Some(5))(_ > 2)) // Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  println(map(Some(5))(_ > 2)) // Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None

  println(map2(Some(5))(Some(2))(_ > _)) // Some(true)
  println(map2(Some(5))(Some(8))(_ > _)) // Some(false)
  println(map2(None[Int]())(Some(8))(_ > _)) // None
  println(map2(Some(8))(None[Int]())(_ > _)) // None