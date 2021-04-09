package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/11727
 *
 * 2xN 타일링에서 정사각형 타일 놓는 경우의 수를 추가하면 된다
 */
fun main(args: Array<String>) {
    println(`2xN 타일링2`().solution(2) == 3)
    println(`2xN 타일링2`().solution(3) == 5)
    println(`2xN 타일링2`().solution(8) == 171)
    println(`2xN 타일링2`().solution(12) == 2731)
    println(`2xN 타일링2`().solution(1) == 1)

    try {
        val fn = `2xN 타일링2`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `2xN 타일링2` {
    fun solution(n: Int): Int {
        if (n == 1) {
            return 1
        }

        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 3

        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10_007
        }

        return dp[n]
    }
}