package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/14002
 * 
 * lis가 갱신될 때 count와 index를 같이 저장하고, index를 역추적하여 출력한다(백트래킹?)
 */
fun main(args: Array<String>) {
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(10,20,10,30,20,50)) == Response(4, intArrayOf(10,20,30,50)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(19,22,23,20,10,30,25)) == Response(4, intArrayOf(19,22,23,30)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(1)) == Response(1, intArrayOf(1)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(3,2,1)) == Response(1, intArrayOf(3)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(1,2,3,4,5,6,7,8)) == Response(8, intArrayOf(1,2,3,4,5,6,7,8)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(1,2)) == Response(2, intArrayOf(1,2)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(50,10,20,10,40)) == Response(3, intArrayOf(10,20,40)))
    println(`가장 긴 증가하는 부분 수열4`().solution(intArrayOf(10,33,34,40,20,30,20,50)) == Response(5, intArrayOf(10,33,34,40,50)))

    try {
        val fn = `가장 긴 증가하는 부분 수열4`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()
        val sequence = br.readLine().split(" ").stream()
            .mapToInt { it.toInt() }
            .toArray()
        val result = fn.solution(sequence)
        println(result.count)
        println(result.lis.toList().joinToString(" "))
    } catch (e: IOException) {/* */}
}

class `가장 긴 증가하는 부분 수열4` {
    fun solution(sequence: IntArray):Response {
        val dp = Array(sequence.size) { intArrayOf(1, -1) }

        var max = dp[0]
        var lastNumber = sequence[0]
        for (i in 1 until sequence.size) {
            for (j in i-1 downTo 0) {
                if (sequence[j] < sequence[i]) {
                    if (dp[j][0] >= dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1
                        dp[i][1] = j
                    }
                }
            }

            max = if (max[0] < dp[i][0]) {
                lastNumber = sequence[i]
                dp[i]
            } else max
        }

        val lis = IntArray(max[0])
        lis[lis.size-1] = lastNumber
        var latestIdx = max[1]
        for (i in lis.size-2 downTo 0) {
            if (latestIdx == -1) {
                break
            }

            lis[i] = sequence[latestIdx]
            latestIdx = dp[latestIdx][1]
        }

        return Response(max[0], lis)
    }
}

data class Response(val count:Int, val lis:IntArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Response

        if (count != other.count) return false
        if (!lis.contentEquals(other.lis)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = count
        result = 31 * result + lis.contentHashCode()
        return result
    }
}