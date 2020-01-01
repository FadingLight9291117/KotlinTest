package adt

// 1. 常量模式
fun constPattern(a: Int) = when (a) {
    1 -> "It is 1"
    2 -> "It is 2"
    else -> "It is other number"
}

// 2. 类型模式
sealed class Shape1 {
    class Circle(val radius: Double) : Shape1()
    class Rectangle(val width: Double, val height: Double): Shape1()
    class Triangle(val base: Double, val height: Double): Shape1()
}
fun getArea(shape: Shape1): Double = when (shape) {
    is Shape1.Circle -> Math.PI * shape.radius * shape.radius
    is Shape1.Rectangle -> shape.height * shape.height
    is Shape1.Triangle -> shape.base * shape.height / 2.0
}

// 3. 逻辑表达式模式
fun logicPattern1(a: Int) = when {
    a in 2..11 -> (a.toString() + " is smaller than 10 and bigger than 1")
    else -> "Maybe" + a + "is bigger than 10, or smaller than 1"
}

fun logicPatter2(a: String) = when {
    a.contains("Yison") -> "Someting is about Yison"
    else -> "It's none of Yison's business"
}

sealed class Expr {
    data class Num(val value: Int) : Expr()
    data class Operate(val opName: String, val left: Expr, val right: Expr) : Expr()
}

fun simplifyExper(expr: Expr): Expr = when {
    (expr is  Expr.Operate) && (expr.opName == "+") && (expr.left is Expr.Num) &&
            (expr.left.value == 0) -> expr.right
    (expr is Expr.Operate) && (expr.opName == "+") && (expr.right is Expr.Num) &&
            (expr.right.value == 0) -> expr.left
    else -> expr
}

// 改进的simplifyExper
fun simpleExper1(expr: Expr): Expr = when (expr){
    is Expr.Num -> expr
    is Expr.Operate -> when (expr) {
        Expr.Operate("+", Expr.Num(0), expr.right) -> expr.right
        Expr.Operate("+", expr.left, Expr.Num(0)) -> expr.left
        else -> expr
    }
}