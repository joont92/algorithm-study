package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/1912
 *
 * 1개부터 n개까지 올라가면서 i번쨰 숫자를 연속으로 더할것인지, i번쨰 숫자부터 다시 시작할것인지 판단하면 된다
 * - 이 과정중에 최대값을 구하면 된다
 * - **자기 자신이 선택될 수도 있기 때문에 이어져 온 연속합은 항상 최대값이다**
 * - 자기 자신이 더 크면 지금까지의 연속합을 끊고 진행하기 때문이다
 */
fun main(args: Array<String>) {
    println(연속합().solution(intArrayOf(10,-4,3,1,5,6,-35,12,21,-1)) == 33)
    println(연속합().solution(intArrayOf(2,1,-4,3,4,-4,6,5,-5,1)) == 14)
    println(연속합().solution(intArrayOf(-1,-2,-3,-4,-5)) == -1)
    println(연속합().solution(intArrayOf(5)) == 5)
    println(연속합().solution(intArrayOf(-1000, 1000)) == 1000)

    try {
        val fn = 연속합()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        println(fn.solution(br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray()))
    } catch (e: IOException) {/* */}
}
class 연속합 {
    fun solution(sequence: IntArray): Int {
        val dp = IntArray(sequence.size)
        dp[0] = sequence[0]

        var max = dp[0]
        for (i in 1 until dp.size) {
            val sum = sequence[i] + dp[i - 1]
            dp[i] = if (sum > sequence[i]) sum else sequence[i]
            max = max(max, dp[i])
        }

        return max
    }
}