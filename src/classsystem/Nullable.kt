package classsystem

data class Seat(val student: Student?)
data class Student(val glasses: Glasses?)
data class Glasses(val degreeOfMyopia: Double)

fun main(args: Array<String>) {
    val degreeOfMyopia = Glasses(0.80)
    val student = Student(degreeOfMyopia)
    val seat = Seat(student)

    println("该位置上学生眼镜度数为：${seat.student?.glasses?.degreeOfMyopia?:-1}") // 安全调用?. Elvis操作符?: 非空断言!!.
}