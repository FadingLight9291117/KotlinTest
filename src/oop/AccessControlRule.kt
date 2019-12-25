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

// 接口 接口内的方法可默认实现
interface Animalx {
    val speed: Int
    fun kind()
    fun fly() {
        println("I can fly!")
    }
}

// kotlin 也有 private protected , 类似于Java
private open class Animal3 {
    private val age: Int = 10
    protected open fun fly() {}
}

fun main(args: Array<String>) {
    val penguin: Animal = Penguin()
    println(penguin.fly())
}