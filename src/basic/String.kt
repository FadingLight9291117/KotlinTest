package basic

// 字符串操作
fun main(args: Array<String>) {
    val str = "hello world"

    str.length
    str.substring(0,5)
    str + " hello Kotlin!"
    str.replace("world", "kotlin")

    str[0]
    str.first()
    str.last()
    str[str.length - 1]

    "".isEmpty()
    " ".isBlank()
    "abcdefg".filter { c -> c in 'a'..'d' }

    for (i in str.toUpperCase()) {
        print(i)
    }
    println()

    // 多行原生字符串
    val rawString = """
        <html>
            <body>
                <p>Hello World</p>
            </body>
        </html>
    """.trimIndent()
    println(rawString)

    // 字符串模板
    val kotlin = "Kotlin"
    val strModel = "Kotlin has ${if (kotlin.length > 0) "Kotlin".length else 0} letters."
    println(strModel)

    // == 内容相等 === 引用相等
    val a = "A"
    val b = "A"
    println(a == b)
    println(a === b)
}