package oop

open class Animal {
    open fun fly() {
        println("I can fly")
    }
}

class Penguin : Animal() {
    override fun fly() {
        println("I can't fly")
    }
}
// 密封类 仅同文件类可以继承它 且它不能初始化
sealed class Animal1 {
    open fun fly() = "I can fly"
    class Eagle : Animal1()
}

// 抽象类
abstract class Animal2 {

}

fun main(args: Array<String>) {
    val penguin: Animal = Penguin()
    println(penguin.fly())
}