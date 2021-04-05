package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/16194
 */
fun main(args: Array<String>) {
    println(`카드 구매하기2`().solution(4, intArrayOf(1,5,6,7)) == 4)
    println(`카드 구매하기2`().solution(5, intArrayOf(10,9,8,7,6)) == 6)
    println(`카드 구매하기2`().solution(10, intArrayOf(1,1,2,3,5,8,13,21,34,55)) == 5)
    println(`카드 구매하기2`().solution(10, intArrayOf(5,10,11,12,13,30,35,40,45,47)) == 26)
    println(`카드 구매하기2`().solution(4, intArrayOf(5,2,8,10)) == 4)

    try {
        val fn = `카드 구매하기2`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        val prices = br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray()
        println(fn.solution(count, prices))
    } catch (e: IOException) {/* */}
}

class `카드 구매하기2` {
    fun solution(n: Int, prices: IntArray): Int {
        val dp = IntArray(n + 1)

        for (i in 1..n) {
            dp[i] = prices[i - 1]
            for (j in 1..i) {
                dp[i] = dp[i].coerceAtMost(prices[j - 1] + dp[i - j])
            }
        }

        return dp[n]
    }
}