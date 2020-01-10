package designpattern


/*
    伴生对象增强工厂方法
    1. 单例代替工厂类
    2. 伴生对象创建静态工厂方法
    3. 扩展伴生对象方法
 */

interface Computer {
    val cpu: String
    fun use()
    companion object Factory {
        operator fun invoke(type: ComputerType): Computer {
            return when (type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}

enum class ComputerType {
    PC, Server
}

class PC(override val cpu: String = "Core"): Computer {
    override fun use() {
       println("This is a PC")
    }
}

class Server(override val cpu: String = "Xeon"): Computer {
    override fun use() {
       println("This is a Server")
    }
}

fun Computer.Factory.fromCPU(cpu: String): ComputerType? = when (cpu) {
    "Core" -> ComputerType.PC
    "Xeon" -> ComputerType.Server
    else -> null
}

fun main() {
    val computer = Computer.Factory(ComputerType.Server)
    computer.use()
    val type = Computer.Factory.fromCPU("Core")
    println(type)
}