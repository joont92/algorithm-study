package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.floor
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * https://www.acmicpc.net/problem/1699
 *
 * fn(n) : n을 만들기 위한 최소 제곱수의 합
 *
 * 최대로 올 수 있는 제곱수는 루트 n 의 제곱이다
 * 루트 n을 i라고 한다면, 첫번째 제곱근으로 올 수 있는 경우의 수는 1~i 까지다
 *
 * 앞에 1이 왔을 때 : 1 + fn(n - 1^2)
 * > +1은 1^2 연산이다
 * 앞에 2가 왔을 때 : 1 + fn(n - 2^2)
 * > +1은 2^2 연산이다
 * 앞에 3이 왔을 때 : 1 + fn(n - 3^2)
 * > +1은 3^2 연산이다
 * ...
 * 이렇게 i까지 진행하면서 최소값을 구하면 된다 // 1,2,3 더하기 문제와 비슷하다
 *
 * bottomUp으로 1부터 n까지 쭉 구한다음, fn(n)의 값을 리턴하면 된다
 *
 * topDown으로 하면 좀 더
 */
fun main(args: Array<String>) {
    println(`제곱수의 합`().solution(7) == 4)
    println(`제곱수의 합`().solution(11) == 3)
    println(`제곱수의 합`().solution(5) == 2)
    println(`제곱수의 합`().solution(1) == 1)
    println(`제곱수의 합`().solution(100_000) == 2)
    println(`제곱수의 합`().solution(144) == 1)
    println(`제곱수의 합`().solution(30) == 3) // 9 + 9 + 4 + 4 + 4

    try {
        val fn = `제곱수의 합`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `제곱수의 합` {
    fun solution(n: Int): Int {
        val dp = IntArray(n + 1)

        // 1부터 n까지
        for (i in 1..n) {
            dp[i] = i // 1^2로만 이루어진 상태

            var j = 2
            while (j * j <= i) {
                dp[i] = min(dp[i], dp[i - j * j] + 1)
                j++
            }
        }

        return dp[n]
    }
}