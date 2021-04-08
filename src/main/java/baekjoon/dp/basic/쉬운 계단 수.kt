package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/10844
 *
 * D[n][i] : 길이가 n이고, 마지막 숫자가 i인 계산수의 개수
 *
 * 계단수는 위아래로 +-1이므로, 점화식은 아래와 같이 된다
 * D[n][i] = D[n-1][i+1] + D[n-1][i-1]
 * > 길이가 n이고 마지막 숫자가 i인 계단수의 개수는 길이가 n-1이고 마지막 숫자가 i-1 또는 i+1 인 계단수 개수의 합이다
 *
 * 0일때는 아래 수가 없고, 9일때는 위 수가 없으므로
 * 최종 점화식은 아래와 같다
 * D[n][0] = D[n-1][1]
 * D[n][9] = D[n-1][8]
 * D[n][i] = D[n-1][i+1] + D[n-1][i-1] // i : 1~8
 *
 * D[n][0] 부터 D[n][9]의 값을 전부 더해주면 된다
 */
fun main(args: Array<String>) {
    println(`쉬운 계단 수`().solution(1) == 9)
    println(`쉬운 계단 수`().solution(2) == 17)

    try {
        val fn = `쉬운 계단 수`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `쉬운 계단 수` {
    val mod = 1_000_000_000

    fun solution(n: Int): Int {
        val dp = Array(n + 1) { IntArray(10) }
        for (i in 1..9) {
            dp[1][i] = 1
        }

        for (i in 2..n) {
            dp[i][0] = dp[i - 1][1]
            dp[i][9] = dp[i - 1][8]
            for (j in 1..8) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod
            }
        }

        return IntRange(0, 9)
            .map { dp[n][it] }
            .reduce { a,b -> (a + b) % mod }
    }
}