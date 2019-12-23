fun main(args: Array<String>) {
    // two ways of Lambda Express
    val sum1 = {x: Int, y: Int -> x + y}
    val sum2: (Int, Int) -> Int = {x,y -> x + y}
    println(sum1(1, 10))
    println(sum2(2, 12))

    listOf(1, 2, 3, 12).forEach { item -> foo(item)}
    listOf(2, 1, 3, 1, 23).forEach { foo(it) }
}

fun foo(int: Int)
{
    print(int);
}