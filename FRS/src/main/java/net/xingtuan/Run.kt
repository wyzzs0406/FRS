package net.xingtuan

import net.xingtuan.Mod.ShouRu
import net.xingtuan.Mod.ZhiChu
import net.xingtuan.Mod.ZongLan
import java.util.Scanner
import kotlin.jvm.Throws

class Run {
    fun run() {
        while (true) {
            val sc = Scanner(System.`in`)
            print("=========================================")
            printTB()
            println("             智能财务管理系统FRS            ")
            println("=========================================")
            println("你好，今天你需要什么?")

            println("请选择(1~4): ")
            println("  1. 收入管理")
            println("  2. 支出管理")
            println("  3. 总览")
            println("  4. 退出")
            print(">>")
            try {
                when (sc.nextInt()) {
                    1 -> {
                        ShouRu().shouRu()
                        Thread.sleep(5000)
                        run()
                    }

                    2 -> {
                        ZhiChu().zhiChu()
                        Thread.sleep(5000)
                        run()
                    }

                    3 -> {
                        ZongLan().zongLan()
                        Thread.sleep(5000)
                        run()
                    }

                    4 -> {
                        println("再见~")
                        Thread.sleep(500)
                        return
                    }

                    else -> {
                        println("输入正确的数字!")
                        run()
                    }
                }
            } catch (e: Exception) {
                println("请输入数字")
                Thread.sleep(500)
            }

        }
    }

    fun printTB() {
        println(
            """
     /${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}${'$'} /${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}   /${'$'}${'$'}${'$'}${'$'}${'$'}${'$'} 
    | ${'$'}${'$'}_____/| ${'$'}${'$'}__  ${'$'}${'$'} /${'$'}${'$'}__  ${'$'}${'$'}
    | ${'$'}${'$'}      | ${'$'}${'$'}  \ ${'$'}${'$'}| ${'$'}${'$'}  \__/
    | ${'$'}${'$'}${'$'}${'$'}${'$'}   | ${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}/|  ${'$'}${'$'}${'$'}${'$'}${'$'}${'$'} 
    | ${'$'}${'$'}__/   | ${'$'}${'$'}__  ${'$'}${'$'} \____  ${'$'}${'$'}
    | ${'$'}${'$'}      | ${'$'}${'$'}  \ ${'$'}${'$'} /${'$'}${'$'}  \ ${'$'}${'$'}
    | ${'$'}${'$'}      | ${'$'}${'$'}  | ${'$'}${'$'}|  ${'$'}${'$'}${'$'}${'$'}${'$'}${'$'}/
    |__/      |__/  |__/ \______/ 
                """
        )
    }

}