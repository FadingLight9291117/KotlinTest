package oop

interface Flyer {
    fun fly()
    fun kind() = "flying animals"
}

interface Animals {
    val name: String
    fun eat()
    fun kind() = "flying animals"
}

class Birds(override val name: String) : Flyer, Animals {
    override fun eat() {
        println("I can eat")
    }

    override fun fly() {
        println("I can fly")
    }

    override fun kind() = super<Flyer>.kind() // super关键字 解决钻石问题
}