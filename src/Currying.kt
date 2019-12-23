fun main(args: Array<String>) {

    foo { println("Hello World!") }

    // the style of invoking of currying
    curryingLike("Hello World!") {
        content ->
        println(content)
    }
}

fun foo(block: () -> Unit) {
    block();
}

fun curryingLike(content: String, block: (String) -> Unit) {
    block(content)
}