package polymorphismAndExtension


data class Student(var name: String, var age: Int, var grade: Int)

fun main(args: Array<String>) {
    val student = Student("车亮召", 21, 4)
    var name: String
    var age: Int
    var grade: Int

    // with 的用法
    with(student) {
        name = this.name
        age = this.age
        grade = this.grade
    }
    println("$name $age $grade")

    // apply 的用法
    val student2 = Student("陈诗琦", 21, 4)
    student2.apply {
        this.name = name
        this.age = age
        this.grade = grade
    }
    println(student2)

    // run 的用法
    run {
        val sentence = "run的用法"
        println(sentence)
    }

    // let 的用法
    val student3 = student2.let {
       Student("陈诗琦", it.age, it.grade)
    }
    println(student3)

    // also 的用法
    val result = student3.also {
        it.age--
        it.grade--
    }
    println(student3)
    println(result)

    // takeif 的用法
    val result2 = student3.takeIf { it.age < 30 }?.let { println("她的年龄小于30岁");it.age }?: -1
}