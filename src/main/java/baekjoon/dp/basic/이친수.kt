package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/2193
 *
 * D[n][i] : 길이가 n이고, 마지막 자리가 i인 이친수
 *
 * i는 0과 1만 올수있고, 0은 연속될 수 있고 1은 연속될 수 없으니 점화식은 아래와 같다
 * D[n][0] : D[n-1][0] + D[n-1][1]
 * D[n][1] : D[n-1][0]
 *
 * 이 둘을 더하면 된다 D[n][0] + D[n][1]
 */
fun main(args: Array<String>) {
    println(이친수().solution(3) == 2L)
    println(이친수().solution(2) == 1L)
    println(이친수().solution(1) == 1L)
    println(이친수().solution(4) == 3L)
    println(이친수().solution(5) == 5L)

    try {
        val fn = 이친수()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class 이친수 {
    fun solution(n: Int): Long {
        val dp = Array(n + 1) { LongArray(2) }
        dp[1][0] = 0
        dp[1][1] = 1

        for (i in 2..n) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][1] = dp[i - 1][0]
        }

        return dp[n][0] + dp[n][1]
    }
}