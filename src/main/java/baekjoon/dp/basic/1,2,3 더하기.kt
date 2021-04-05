package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/9095
 *
 * f(n) : 1,2,3의 합으로 나타내는 경우의 수
 * 첫번째 피연산자로 올 수 있는 수 : 1,2,3
 * 앞에 1이 왔을 때 경우의 수 : f(n-1)
 * 앞에 2가 왔을 때 경우의 수 : f(n-2)
 * 앞에 3이 왔을 때 경우의 수 : f(n-3)
 *
 * 이 3개를 다 더하면 된다
 * f(n) = f(n-1) + f(n-2) + f(n-3)
 */
fun main(args: Array<String>) {
    println(`1,2,3 더하기`().solution(4) == 7)
    println(`1,2,3 더하기`().solution(7) == 44)
    println(`1,2,3 더하기`().solution(10) == 274)
    println(`1,2,3 더하기`().solution(3) == 4)
    println(`1,2,3 더하기`().solution(2) == 2)
    println(`1,2,3 더하기`().solution(1) == 1)

    try {
        val fn = `1,2,3 더하기`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        for (i in 1..count) {
            println(fn.solution(br.readLine().toInt()))
        }
    } catch (e: IOException) {/* */}
}
class `1,2,3 더하기` {
    fun solution(n: Int): Int {
        val dp = IntArray(11)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        for (i in 4..n) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }

        return dp[n]
    }
}