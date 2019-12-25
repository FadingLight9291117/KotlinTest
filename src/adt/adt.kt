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

fun schedule(day: Day): String =
    when (day) {
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

}