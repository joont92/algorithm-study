package baekjoon.bruteforce.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/1476
 */
fun main(args: Array<String>) {
    println(`날짜 계산`().solution(intArrayOf(15, 15, 15)) == 15)
    println(`날짜 계산`().solution(intArrayOf(1, 16, 16)) == 16)
    println(`날짜 계산`().solution(intArrayOf(1, 1, 1)) == 1)
    println(`날짜 계산`().solution(intArrayOf(1, 2, 3)) == 5266)
    println(`날짜 계산`().solution(intArrayOf(15, 28, 19)) == 7980)

    try {
        val fn = `날짜 계산`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val result = fn.solution(br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray())
        println(result)
    } catch (e: IOException) {/* */}
}

class `날짜 계산` {
    fun solution(esm: IntArray): Int {
        var year = 1
        var e = 1
        var s = 1
        var m = 1

        while (!(e == esm[0] && s == esm[1] && m == esm[2])) {
            year++
            e = if (e == 15) 1 else e + 1
            s = if (s == 28) 1 else s + 1
            m = if (m == 19) 1 else m + 1
        }

        return year
    }
}