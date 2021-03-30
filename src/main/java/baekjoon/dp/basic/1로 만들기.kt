package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/1463
 *
 * f(n) : n이 1이 되기 위한 최소 연산 회수
 * +1 연산을 할 경우 f(n) = f(n-1) + 1
 * /2 연산을 할 경우 f(n) = f(n/2) + 1
 * /3 연산을 할 경우 f(n) = f(n/3) + 1
 * > +1은 연산을 1번 했음을 뜻함
 * > e.g. +1 연산을 1번 했으니 n은 n-1이 되고, 연산 횟수에 +1을 한다
 *
 * 점화식 : f(n) = min(f(n-1)+1, f(n/2)+1, f(n/3)+1)
 */
fun main(args: Array<String>) {
    println(`1로 만들기`().solution(2) == 1)
    println(`1로 만들기`().solution(10) == 3)

    try {
        val fn = `1로 만들기`()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `1로 만들기` {
    fun solution(number: Int):Int {
        val dp = IntArray(number + 1)
        dp[1] = 0

        for (i in 2..number) {
            dp[i] = dp[i - 1] + 1
            if (i % 2 == 0) {
                dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
            }
            if (i % 3 == 0) {
                dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
            }
        }

        return dp[number]
    }
}