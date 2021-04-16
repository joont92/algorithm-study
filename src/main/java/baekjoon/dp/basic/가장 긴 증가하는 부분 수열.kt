package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/11053
 *
 * 앞에서부터 자신의 LIS를 배열에 기록한다
 * arr = 10 20 10 30 20 50
 * lis =  1  2  1  3  2  4
 *
 * LIS를 구하는 방법은 아래와 같다
 * 1. 자신 앞의 숫자부터 첫번째 숫자까지 내려가면서 검사한다
 * 2. 자신보다 작은 숫자이고, 현재 자신의 LIS보다 클 경우 자신의 LIS를 해당 숫자의 LIS+1로 덮어쓴다(LIS 기본값은 1이다)
 *
 *
 */
fun main(args: Array<String>) {
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(10,20,10,30,20,50)) == 4)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(19,22,23,20,10,30,25)) == 4)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(1)) == 1)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(3,2,1)) == 1)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(1,2,3,4,5,6,7,8)) == 8)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(1,2)) == 2)
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(50,10,20,10,40)) == 3)

    // 30 다음에 20이 나왔을떄, 이미 30에 수열 길이가 반영되어 있을것이라고 생각해서 break 하는 로직이 있었는데,
    // 아래와 예시와 같이 20을 30애 반영하더라도 앞에 더 긴 LIS가 있을 수 있으므로, 결국 전체를 다 검사해야한다
    println(`가장 긴 증가하는 부분 수열`().solution(intArrayOf(10,33,34,40,20,30,20,50)) == 5)

    try {
        val fn = `가장 긴 증가하는 부분 수열`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        val sequence = br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray()
        println(fn.solution(sequence))
    } catch (e: IOException) {/* */}
}

class `가장 긴 증가하는 부분 수열` {
    fun solution(sequence: IntArray): Int {
        val dp = IntArray(sequence.size) { 1 }

        var max = 1
        for (i in 1 until sequence.size) {
            for (j in i-1 downTo 0) {
                if (sequence[j] < sequence[i]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1
                    }
                }
            }

            max = max(dp[i], max)
        }

        return max
    }
}