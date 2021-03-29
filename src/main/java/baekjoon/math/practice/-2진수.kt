package baekjoon.math.practice

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.ceil

/**
 * https://www.acmicpc.net/problem/2089
 *
 * -2로 나누면서 나머지를 구한 뒤 거꾸로 읽어주면 된다(이진변환과 동일)
 * 대신 나머지는 음수가 될 수 없으므로, +가 되도록 처리해주면 된다
 */
fun main(args: Array<String>) {
    println(`-2진수`().solution(-13) == "110111")
    println(`-2진수`().solution(1) == "1")
    println(`-2진수`().solution(2) == "110")
    println(`-2진수`().solution(3) == "111")
    println(`-2진수`().solution(0) == "0")

    try {
        val fn = `-2진수`()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `-2진수` {
    fun solution(arg: Int): String {
        if (arg == 0) {
            return "0"
        }

        val sb = StringBuilder()
        var number = arg
        while (number != 0) {
            val half = ceil(number / -2.0).toInt()
            sb.append(abs(abs(number) - abs(half * -2)))
            number = half
        }

        return sb.reverse().toString()
    }
}