package basic

fun main(args: Array<String>) {
    // "when" is same as "switch"
    val day = Day.MON
    val result = schedule(true, day)
    println(result)

    // for statement
    for (i in 0..9) { // .. 范围表达式range
        print(i)
    }
    println()
    for (i in 9 downTo 0) { // downTo 倒序
        print(i)
    }
    println()
    for (i in 0 until 10) { // 半开区间
        print(i)
    }
    println()
    for (i in 0..9 step 2) {
        print(i)
    }
    println()
    for (i in 'a'..'z') {
        print(i)
    }
    println()

}

fun schedule(sunny: Boolean, day: Day) = when (day) {
    Day.SAT -> "basketball"
    Day.SUN -> "fishing"
    Day.FRI -> "appointment"
    else -> when {
        sunny -> "library"
        else -> "study"
    }
}