package baekjoon.bruteforce.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.log10
import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/1748
 *
 * 현재 자릿수에서 한자리 작은 자리수의 최대값을 뺀 숫자에, 현재 자리수의 크기만큼 더하면서 총 크기를 구한다
 * 1912 = ((1912 - 999) * 4) + ((999 - 99) * 3) + ((99 - 9) * 2) + (9 * 1)
 */
fun main(args: Array<String>) {
    println(`수 이어쓰기`().solution(120) == 252)
    println(`수 이어쓰기`().solution(9) == 9)
    println(`수 이어쓰기`().solution(10) == 11)
    println(`수 이어쓰기`().solution(91) == 173)
    println(`수 이어쓰기`().solution(191) == 465)
    println(`수 이어쓰기`().solution(100_000_000) == 788888898)

    try {
        val fn = `수 이어쓰기`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `수 이어쓰기` {
    fun solution(n: Int): Int {
        var count = 0
        var number = n

        while (number > 0) {
            val length = log10(number.toDouble()).toInt() + 1
            val smaller = if (length == 1) 0 else 10.toDouble().pow(length - 1).toInt() - 1
            count += (number - smaller) * length
            number = smaller
        }

        return count
    }
}