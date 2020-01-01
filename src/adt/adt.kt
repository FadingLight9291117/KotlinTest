package adt

sealed class Day { // 使用密封类
    class SUN : Day()
    class MON : Day()
    class TUE : Day()
    class WED : Day()
    class THU : Day()
    class FRI : Day()
    class SAT : Day()
}

fun schedule(day: Day): String = when (day) { // 使用when时无需考虑else
        is Day.SUN -> "fishing"
        is Day.MON -> "work"
        is Day.TUE -> "study"
        is Day.WED -> "library"
        is Day.THU -> "writing"
        is Day.FRI -> "appointment"
        is Day.SAT -> "basketball"
}

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double): Shape()
    class Triangle(val base: Double, val height: Double): Shape()
}

fun getArea(shape: Shape): Double = when (shape) {
    is Shape.Circle -> Math.PI * shape.radius * shape.radius
    is Shape.Rectangle -> shape.height * shape.height
    is Shape.Triangle -> shape.base * shape.height / 2.0
}
