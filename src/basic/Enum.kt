package basic

fun main(args: Array<String>) {
    val day: Day = Day.MON
    println(day)

    val date: DayOfWeek = DayOfWeek.FRI
    println(date)
    println(date.getDayNumber())
}

enum class Day {
    MON,
    TUE,
    WEN,
    THU,
    FRI,
    SAT,
    SUN
}

enum class DayOfWeek(val day: Int) {
    MON(1),
    TUE(2),
    WEN(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);

    fun getDayNumber(): Int {
        return day
    }
}
