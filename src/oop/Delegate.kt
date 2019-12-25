package oop

// 委托实现多继承

interface CanFly {
    fun fly ()
}

interface CanEat {
    fun eat()
}

open class Flyer1 : CanFly {
    override fun fly() {
       println("I can fly")
    }
}

open class Animal0 : CanEat {
    override fun eat() {
       println("I can eat")
    }
}

class Bird0(flyer: Flyer1, animal: Animal0) : CanFly by flyer, CanEat by animal {}

fun main(args: Array<String>) {
    val fly = Flyer1()
    val animal = Animal0()
    val bird = Bird0(fly, animal)
    bird.eat()
    bird.fly()
}