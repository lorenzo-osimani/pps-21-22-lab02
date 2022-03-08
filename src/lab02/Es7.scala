package lab02

object Es7 extends App:
  enum Shape:
      case Rectangle(side1: Double, side2: Double)
      case Circle(radius: Double)
      case Square(side: Double)

  object GeometricCalculations:
    import Shape.*

    def perimeter(shape: Shape): Double = applyOperation(shape, (x, y) => (x + y) * 2, _ * 2 * Math.PI)

    def area(shape: Shape): Double = applyOperation(shape, (x, y) => x * y, Math.pow(_, 2) * Math.PI)

    def applyOperation(shape: Shape, quadrilateralFunction: (Double, Double) => Double,
                       circleFunction: Double => Double): Double = shape match
      case Rectangle(side1, side2) => quadrilateralFunction(side1, side2)
      case Circle(radius) => circleFunction(radius)
      case Square(side) => quadrilateralFunction(side, side)