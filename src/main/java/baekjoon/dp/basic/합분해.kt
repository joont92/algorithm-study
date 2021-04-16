package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/2225
 *
 * fn(n, k) : k개의 숫자로 n을 만들기 위한 경우의 수
 * fn(n, k)를 구하려면,
 * 첫번째 피연산자로 0부터 n까지 오고, 이후 피연산자는 fn(n-i, k-1)으로 올 수 있는 숫자들의 묶음이 오면 된다
 * 경우의 수를 더하는 것이므로 위의 문장을 하나의 연산으로 보면 되니까..
 * 최종 점화식 : fn(n, k) = fn(n-i, k-1) // 0 <= i <= n
 *
 * fn(10, 3)을 구해야한다고 가정해보면,
 * fn(10, 3) = (0 + fn(10, 2)) + (1 + fn(9, 2)) + (2 + fn(8, 2)) + (3 + fn(7, 2)) ...
 * 이 되는 것이다
 *
 * 0 + fn(10, 2) 를 또 풀어서 보면
 * 0 + 1 + 9
 * 0 + 2 + 8
 * 0 + 3 + 7
 * ...
 * 의 형태가 된다
 *
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