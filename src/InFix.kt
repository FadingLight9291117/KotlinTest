// 定义一个中缀表达式，并使用
fun main(args: Array<String>) {

    val person = Person()
    person called "Kotlin"
}

class Person {
    infix fun called(name: String) {
        println("My name is ${name}.")
    }
}