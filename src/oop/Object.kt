package oop

// companion object 伴生对象 类似static 功能
class Prize(val name: String, val count: Int, val type: Int) {
    companion object {
        val TYPE_REDPACK = 0
        val TYPE_COUPON = 1

        fun isRedpack(prize: Prize): Boolean {
            return prize.type == TYPE_REDPACK
        }
    }
}



fun main(args: Array<String>) {
    val prize = Prize("红包", 10, Prize.TYPE_REDPACK)
    print(Prize.isRedpack(prize))
}