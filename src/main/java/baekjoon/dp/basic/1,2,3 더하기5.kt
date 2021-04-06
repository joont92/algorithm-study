package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/15990
 *
 * 마지막으로 오는 수가 1이면? 그 앞에 올 수 있는 숫자는 2 또는 3이 된다.
 * 마지막으로 오는 수가 2이면? 그 앞에 올 수 있는 숫자는 1 또는 3이 된다.
 * 마지막으로 오는 수가 3이면? 그 앞에 올 수 있는 숫자는 1 또는 2가 된다.
 * 라는 규칙을 갖고 문제를 풀 것이다.
 *
 * 점화식은 이차원 배열로 구성이 되고,
 * D[n][i]마지막에 오는 수가 i일 때, 1,2,3의 합으로 정수 n을 만드는 경우의 수(반복되지 않고)
 * 마지막에 오는 수가 1일때, 2일때, 3일때의 경우의 수를 모두 더한 것이 결과가 되므로
 * result = D[n][1] + D[n][2] + D[n][3] 이 된다
 *
 * D[n][1] = D[n-1][2] + D[n-1][3]
 * > 마지막에 오는 수가 1이니까, 그 앞에 수는 2,3 만 올 수 있다. 여기서 이미 마지막에 1을 더했으니, n 에서는 1을 빼줘야 한다
 * D[n][2] = D[n-2][1] + D[n-2][3]
 * D[n][3] = D[n-3][1] + D[n-3][2]
 *
 * n 이 10이라고 가정하면,
 * 1. 마지막에 1이 올 수 있는 경우의 수
 * D[10][1] = D[9][2] + D[9][3] // 9에 대해 마지막에 2가 올 수 있는 경우의 수 + 마지막에 3이 올 수 있는 경우의 수
 * D[9][2] = D[7][1] + D[7][3]
 * D[9][3] = D[6][1] + D[6][2]
 * D[6][1] = D[5][2] + D[5][3]
 * ...
 * 2. 마지막에 2가 올 수 있는 경우의 수
 * D[10][2] = D[9][1] + D[9][3]
 * ...
 * 3. 마지막에 3이 올 수 있는 경우의 수
 * D[10][3] = ...
 */
fun main(args: Array<String>) {
    println(`1,2,3 더하기5`().solution(4) == 3L)
    println(`1,2,3 더하기5`().solution(7) == 9L)
    println(`1,2,3 더하기5`().solution(10) == 27L)
    println(`1,2,3 더하기5`().solution(3) == 3L)
    println(`1,2,3 더하기5`().solution(2) == 1L)
    println(`1,2,3 더하기5`().solution(1) == 1L)
    println(`1,2,3 더하기5`().solution(100_000) == 1437690563L)

    try {
        val fn = `1,2,3 더하기5`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        for (i in 1..count) {
            println(fn.solution(br.readLine().toInt()))
        }
    } catch (e: IOException) {/* */}
}

class `1,2,3 더하기5` {
    val mod = 1_000_000_009
    val dp = Array(100_001) { LongArray(3 + 1) }

    init {
        dp[1][1] = 1
        dp[2][2] = 1
        dp[3][1] = 1
        dp[3][2] = 1
        dp[3][3] = 1

        for (i in 4..100_000) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod
        }
    }

    fun solution(n: Int): Long {
        return (dp[n][1] + dp[n][2] + dp[n][3]) % mod
    }

    // for one time
    /*
    fun solution(n: Int): Long {
        val rowSize = (if (n < 3) 3 else n) + 1
        val dp = Array(rowSize) { LongArray(3 + 1) }
        dp[1][1] = 1
        dp[2][2] = 1
        dp[3][1] = 1
        dp[3][2] = 1
        dp[3][3] = 1

        for (i in 4..n) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod
        }

        return dp[n][1] + dp[n][2] + dp[n][3]
    }
    */
}