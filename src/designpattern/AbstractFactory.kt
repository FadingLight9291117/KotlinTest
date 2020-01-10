package designpattern

/*
    内联函数简化抽象工厂
 */

interface Computer1
class Dell: Computer1
class Asus: Computer1
class Acer: Computer1

abstract class AbstractFactory {
    abstract  fun produce(): Computer1
    companion object {
        inline operator fun <reified T: Computer1> invoke(factory: AbstractFactory) =
            when (T::class) {
                Dell::class -> DellFactory()
                Asus::class -> AsusFactory()
                Acer::class -> AcerFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class DellFactory: AbstractFactory() {
    override fun produce() = Dell()
}

class AsusFactory: AbstractFactory() {
    override fun produce(): Computer1 = Asus()
}

class AcerFactory: AbstractFactory() {
    override fun produce() = Acer()
}

fun main() {
    val dellFactory = AbstractFactory<Dell>(DellFactory())
    val computer = dellFactory.produce()
    println(computer)
}