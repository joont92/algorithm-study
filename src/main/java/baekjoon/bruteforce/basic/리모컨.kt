package baekjoon.bruteforce.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/1107
 *
 * 0번부터 888888번까지 돌면서 해당 번호를 누를 수 있을 경우
 * > 이동하고자하는 최대 채널은 500000인데, 999999번을 눌려서 내려가는 방법은 100번부터 +버튼을 누르는 것 보다 총 횟수가 많기 때문이다
 * 해당 번호로 가기위해 누른 버튼 횟수와 targetNumber와의 차이(+- 버튼)를 더한다
 * 이 중 최소값을 출력한다
 */
fun main(args: Array<String>) {
    println(리모컨().solution(12, intArrayOf(0,1,3)) == 4)
    println(리모컨().solution(5000, intArrayOf(0,1,2,3,5,6,7,9)) == 116)
    println(리모컨().solution(5457, intArrayOf(6,7,8)) == 6)
    println(리모컨().solution(100, intArrayOf(0,1,2,3,4)) == 0)
    println(리모컨().solution(500000, intArrayOf(0,2,3,4,6,7,8,9)) == 11117)
    println(리모컨().solution(1, intArrayOf(1)) == 2)
    println(리모컨().solution(1, intArrayOf()) == 1)
    println(리모컨().solution(0, intArrayOf(1)) == 1)

    try {
        val fn = 리모컨()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val num = br.readLine().toInt()
        val brokenCount = br.readLine().toInt()
        val array = IntArray(brokenCount)
        if (brokenCount > 0) {
            val str = br.readLine().split(" ")
            for (i in array.indices) {
                array[i] = str[i].toInt()
            }
        }
        println(fn.solution(num, array))
    } catch (e: IOException) {/* */}
}

class 리모컨 {
    private val broken = BooleanArray(10)

    fun solution(targetNumber: Int, brokenNumbers: IntArray): Int {
        for (i in brokenNumbers) {
            broken[i] = true
        }

        var result = abs(targetNumber - 100)
        for (i in 0..888888) {
            val count = check(i)

            if (count > 0) {
                val totalCount = abs(targetNumber - i) + count

                if (totalCount < result) {
                    result = totalCount
                }
            }
        }

        return result
    }

    fun check(i: Int): Int {
        if (i == 0) {
            return if (!broken[0]) 1 else 0
        }

        var count = 0
        var n = i
        while (n != 0) {
            if (broken[n % 10]) return 0
            n /= 10
            count++
        }

        return count
    }
}