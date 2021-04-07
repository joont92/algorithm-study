package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/10844
 */
fun main(args: Array<String>) {
    println(`쉬운 계단 수`().solution(1) == 9L)
    println(`쉬운 계단 수`().solution(2) == 17L)

    try {
        val fn = `쉬운 계단 수`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `쉬운 계단 수` {
    val mod = 1_000_000_000

    fun solution(n: Int): Long {
        val dp = Array(n + 1) { LongArray(10) }
        for (i in 1..9) {
            dp[1][i] = 1
        }

        for (i in 2..n) {
            for (j in 0..9) {
                when (j) {
                    0 -> dp[i][j] = dp[i - 1][1] % mod
                    9 -> dp[i][j] = dp[i - 1][8] % mod
                    else -> dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
                }
            }
        }

        return IntRange(0, 9)
            .map { dp[n][it] }
            .sum() % mod
    }
}