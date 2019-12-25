package oop

//数据类相当与JavaBean

data class Bird3(var weight: Double, var age: Int, var color: String)

fun main(args: Array<String>) {
    val a1 = Bird3(22.2, 12, "white")
    val a2 = a1.copy(age = 10)  // copy方法
    val (weight, age, color) = a2   // component 方法
    println("$weight $age $color")

    val birdInfo = "20.0,1,blue"
    val (weight1, age1, color1) = birdInfo.split(",") // 解构
    println("$weight1 $age1 $color1")

    // Pair 和 Triple 二元组和三元组

    val pair = Pair(20.2, 1)
    val triple = Triple(12.1, 12, "blue")
    // 顺序赋值
    val first = triple.first
    val second = triple.second
    val third = triple.third
    // 解构赋值
    val (weight3, age3, color3) = triple
}