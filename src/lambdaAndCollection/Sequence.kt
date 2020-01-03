package lambdaAndCollection

// 通过序列提高效率 asSequence()

fun main(args: Array<String>) {
    val list = listOf(2, 2, 12, 4, 44)
    val list2 = list.asSequence().filter { it > 4 }.map { it*it }.toList()
    list2.forEach { print("$it ") }
}