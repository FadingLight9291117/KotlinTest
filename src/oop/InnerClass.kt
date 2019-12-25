package oop

// 内部类 实现多继承的功能

open class Horse { // 马
    fun funFast() {
        println("I can run fast")
    }
}

open class Donkey {
    fun doLongTimeThing() { // 驴
        println("I can do some thing long time ")
    }
}

class Mule { // 骡子
    fun runFast() {
        HorseC().funFast()
    }

    fun doLongTimeThing() {
        DonkeyC().doLongTimeThing()
    }

    private inner class HorseC : Horse()
    private inner class DonkeyC : Donkey()
}

fun main(args: Array<String>) {
    val mule = Mule()
    mule.doLongTimeThing()
    mule.runFast()
}