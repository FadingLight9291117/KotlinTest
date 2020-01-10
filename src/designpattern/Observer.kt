package designpattern

import java.util.*
import kotlin.properties.Delegates

// Java 的java.util.Observable 和java.util.Observer接口
class StockUpdate: Observable() {
    val observers = mutableSetOf<Observer>()

    fun setStockChanged(price: Int) {
        this.observers.forEach { it.update(this, price) }
    }
}

class StockDisplay: Observer {
    override fun update(o: Observable, price: Any) {
        if (o is StockUpdate) {
            println("This latest stock's price is $price")
        }
    }
}

// 用委托属性改造

interface StockUpdateListener {
    fun onRise(price: Int)
    fun onFall(price: Int)
}

class StockDisplay2: StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock's price has risen to ${price}.")
    }

    override fun onFall(price: Int) {
        println("The latest stock's price has fallen to ${price}.")
    }
}

class StockUpdate2 {
    var listeners = mutableSetOf<StockUpdateListener>()

    var price: Int by Delegates.observable(0) {
            _, old, new ->
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFall(price)
        }
    }
}

fun main() {
    val observer1 = StockDisplay()
    val observer2 = StockDisplay()
    val stockUpdate = StockUpdate()
    stockUpdate.observers.add(observer1)
    stockUpdate.observers.add(observer2)
    stockUpdate.setStockChanged(100)
    stockUpdate.setStockChanged(90)


    // Vetoable
    var value: Int by Delegates.vetoable(0) {
        prop, old, new ->
        new > 0
    }

    value = 1
    value = -1
    println(value)
}