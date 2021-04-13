package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/2225
 *
 * fn(n, k) : k개의 숫자로 n을 만들기 위한 경우의 수
 * 10 2 : 010 19 28 37 46 55 64 73 82 91 100
 * 20 2 : 020 119 218 317 416 515 614 713 812 911 1010 119 128 137 146 155 164 173 182 191 200
 * = 0~20, 20-0
 *
 * 20 3
 * =
 */
fun main(args: Array<String>) {
    println(합분해().solution(10, 2) == 11)
    println(합분해().solution(20, 2) == 21)
    println(합분해().solution(3, 3) == 10)
    println(합분해().solution(1, 1) == 1)
    println(합분해().solution(2, 1) == 1)

    try {
        val fn = 합분해()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val args = br.readLine().split(" ")
        println(fn.solution(args[0].toInt(), args[1].toInt()))
    } catch (e: IOException) {/* */}
}

class 합분해 {
    val mod = 1_000_000_000

    fun solution(number: Int, count: Int):Int {
        val dp = Array(number + 1) { IntArray(count + 1) }

        for (i in 0..number) {
            dp[i][1] = 1
        }

        for (i in 2..count) {
            for (j in 0..number) {
                for (k in 0..j) {
                    dp[j][i] += dp[j - k][i - 1]
                    dp[j][i] %= mod
                }
            }
        }

        return dp[number][count] % mod
    }
}