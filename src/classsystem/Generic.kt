package classsystem


class SmartList<T> : ArrayList<T>() {
    fun find(t: T): T? {
        val index = super.indexOf(t)
        return if (index >= 0) super.get(index) else null
    }
}

fun <T>ArrayList<T>.find(t: T): T? {
    val index = this.indexOf(t)
    return if (index >= 0) this.get(index) else null
}

// 类型约束:设定类型上界

open class Fruit(val weight: Double)
class Apple(weight: Double): Fruit(weight)
class Banana(weight: Double): Fruit(weight)

class Fruits<T: Fruit>(val t: T)

fun main() {
    val appleFruit = Fruits<Apple>(Apple(10.0))
}