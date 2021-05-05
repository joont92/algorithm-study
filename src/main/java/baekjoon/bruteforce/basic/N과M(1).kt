package baekjoon.bruteforce.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.stream.Collectors
import java.util.stream.Stream

/**
 * https://www.acmicpc.net/problem/15649
 *
 * nPm 경우의 수를 모두 출력하면 된다
 */
fun main(args: Array<String>) {
    println(`N과M(1)`().solution(3,1) contentDeepEquals
            arrayOf(
                intArrayOf(1),
                intArrayOf(2),
                intArrayOf(3)
            )
    )
    println(`N과M(1)`().solution(4,2) contentDeepEquals
            arrayOf(
                intArrayOf(1,2),
                intArrayOf(1,3),
                intArrayOf(1,4),
                intArrayOf(2,1),
                intArrayOf(2,3),
                intArrayOf(2,4),
                intArrayOf(3,1),
                intArrayOf(3,2),
                intArrayOf(3,4),
                intArrayOf(4,1),
                intArrayOf(4,2),
                intArrayOf(4,3)
            )
    )
    println(`N과M(1)`().solution(4,4) contentDeepEquals
            arrayOf(
                intArrayOf(1,2,3,4),
                intArrayOf(1,2,4,3),
                intArrayOf(1,3,2,4),
                intArrayOf(1,3,4,2),
                intArrayOf(1,4,2,3),
                intArrayOf(1,4,3,2),
                intArrayOf(2,1,3,4),
                intArrayOf(2,1,4,3),
                intArrayOf(2,3,1,4),
                intArrayOf(2,3,4,1),
                intArrayOf(2,4,1,3),
                intArrayOf(2,4,3,1),
                intArrayOf(3,1,2,4),
                intArrayOf(3,1,4,2),
                intArrayOf(3,2,1,4),
                intArrayOf(3,2,4,1),
                intArrayOf(3,4,1,2),
                intArrayOf(3,4,2,1),
                intArrayOf(4,1,2,3),
                intArrayOf(4,1,3,2),
                intArrayOf(4,2,1,3),
                intArrayOf(4,2,3,1),
                intArrayOf(4,3,1,2),
                intArrayOf(4,3,2,1)
            )
    )

    try {
        val fn = `N과M(1)`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val arg = br.readLine().split(" ")
        val result = fn.solution(arg[0].toInt(), arg[1].toInt())
        for (element in result) {
            println(element.joinToString(" "))
        }
    } catch (e: IOException) {/* */}
}

class `N과M(1)` {
    lateinit var array: Array<IntArray>
    var idx = 0
    fun solution(n: Int, m: Int): Array<IntArray> {
        array = Array(permutation(n, m)) { IntArray(m) }
        recursive(n, m, BooleanArray(n), IntArray(m), 0)

        return array
    }

    fun recursive(n: Int, m: Int, check: BooleanArray, element: IntArray, elementIdx: Int) {
        if (m == 0) {
            array[idx++] = element.copyOf()
            return
        }

        for (i in 0 until n) {
            if (check[i]) {
                continue
            }
            check[i] = true
            element[elementIdx] = i + 1
            recursive(n, m - 1, check, element, elementIdx + 1)
            check[i] = false
        }
    }

    private fun permutation(n: Int, m: Int): Int {
        var result = 1
        for (i in 0 until m) {
            result *= (n - i)
        }
        return result
    }
}