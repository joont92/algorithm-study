package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/11052
 *
 * f(n) = 카드 n개를 구매하기 위해 드는 최대값
 * p(n) = n개 카드가 들어있는 덱의 가격
 *
 * 4개의 카드를 구매해야 한다고 했을 떄,
 * 1개 덱 카드를 선택했을 경우 : p(1) + f(n-1)
 * 2개 덱 카드를 선택했을 경우 : p(2) + f(n-2)
 * 3개 덱 카드를 선택했을 경우 : p(3) + f(n-3)
 * 4개 덱 카드를 선택했을 경우 : p(4) + f(n-4)
 *
 * 이 값들의 max를 구하면 된다 : max(prices(i) + fn(n-i))
 */
fun main(args: Array<String>) {
    println(`카드 구매하기`().solution(4, intArrayOf(1,5,6,7)) == 10)
    println(`카드 구매하기`().solution(5, intArrayOf(10,9,8,7,6)) == 50)
    println(`카드 구매하기`().solution(10, intArrayOf(1,1,2,3,5,8,13,21,34,55)) == 55)

    println(`카드 구매하기 topDown`(4).solution(4, intArrayOf(1,5,6,7)) == 10)
    println(`카드 구매하기 topDown`(5).solution(5, intArrayOf(10,9,8,7,6)) == 50)
    println(`카드 구매하기 topDown`(10).solution(10, intArrayOf(1,1,2,3,5,8,13,21,34,55)) == 55)

    try {
        val fn = `카드 구매하기`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        val prices = br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray()
        println(fn.solution(count, prices))
    } catch (e: IOException) {/* */}
}

/**
 * 1개일 경우 최대 금액(prices[1]) 부터 n 개일 경우 최대 금액까지 쌓아 올리기
 */
class `카드 구매하기` {
    // bottomUp
    fun solution(n: Int, prices: IntArray): Int {
        val dp = IntArray(n + 1)

        for (i in 1..n) {
            for (j in 1..i) {
                dp[i] = dp[i].coerceAtLeast(prices[j - 1] + dp[i - j])
            }
        }

        return dp[n]
    }
}

class `카드 구매하기 topDown`(n: Int) {
    // topDown
    private val dp = IntArray(n + 1)
    fun solution(n: Int, prices: IntArray): Int {
        if (dp[n] > 0) {
            return dp[n]
        }

        for (i in 1..n) {
            dp[n] = dp[n].coerceAtLeast(prices[i - 1] + solution(n - i, prices))
        }

        return dp[n]
    }
}

