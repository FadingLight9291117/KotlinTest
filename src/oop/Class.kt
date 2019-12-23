package oop

import java.time.LocalDateTime



class Bird {
    val weight: Double = 500.0
    val color: String = "blue"
    val age: Int = 1
    fun fly() {} // 全局可见
}

class Cat(val weight: Double = 0.0, val age:Int = 0, val color: String = "blue")
// 类似于
class Cat1 (weight: Double = 0.0, age:Int = 0, color: String = "blue") {
    val weight: Double = weight
    val age: Int = age
    val color: String = color
}
// 类似于
class Cat2 (weight: Double = 0.0, age:Int = 0, color: String = "blue") {
    val weight: Double
    val age: Int
    val color: String

    init { // init语句块 执行初始化的的其他操作
        this.weight = weight
        this.age = age
        this.color = color
    }
}

// 延迟初始化 by lazy 和 lateinit
class Brid1(val weight: Double, val age: Int, val color: String) {
    val sex: String by lazy {
        if (color == "yellow") "male" else "female"
    }
}
class Bird2(val weight: Double, val age: Int, val color: String) {
    lateinit var sex: String // sex 可以延迟初始化

    fun printSex() {
        this.sex = if (this.color == "yellow") "male" else "female"
        println(this.sex)
    }
}

// 主从构造方法
class Pig(age: Int) {
    val age: Int
    init {
        this.age = age
    }
    // 从构造方法
    constructor(birth: LocalDateTime) : this(LocalDateTime.now().year - birth.year)
}

fun main(args: Array<String>) {
    var bird = Bird()
    var cat = Cat(10.0, 3)
    val date = LocalDateTime.of(2008, 1, 12, 12, 23)
    val pig = Pig(date)
    println(pig.age)
}
