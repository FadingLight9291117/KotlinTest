package designpattern

import java.lang.IllegalArgumentException


/*
    用具名可选参数代替建造者模式
 */

// 建造者模式
class Robot private constructor(
    val code: String,
    val battery: String?,
    val height: Int?,
    val weight: Int?) {

    class Builder(val code: String) {   // 嵌套类
        private var battery: String? = null
        private var height: Int? = null
        private var weight: Int? = null

        fun  setBattery(battery: String?): Builder {
            this.battery = battery
            return this
        }

        fun setHeight(height: Int?): Builder {
            this.height = height
            return this
        }

        fun setWeight(weight: Int?): Builder {
            this.weight = weight
            return this
        }

        fun builder(): Robot {
            if (weight != null && battery == null) {
                throw IllegalArgumentException("Battery should be determined when setting weight.")
            } else {
                return Robot(code, battery, height, weight)
            }
        }
    }
}

// 使用具名可选参数
class Robot2(
    val code: String,
    val battery: String? = null,
    val height: Int? = null,
    val weight: Int? = null
) {
    init {
        require(weight == null || battery != null) {
            "Battery should be determined when setting weight."
        }
    }
}

fun main() {
    val robot = Robot.Builder("007")
        .setBattery("R6")
        .setHeight(100)
        .setWeight(80)
        .builder()
    println(robot)

    // 具名可选参数代替建造者模式
    val robot2 = Robot2(code = "001", battery = "R6", height = 100, weight = 80)
    println(robot2)
}