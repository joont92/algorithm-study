package baekjoon.bruteforce.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/2309
 *
 * 9명 중 2명을 뽑아 키를 더한 뒤, 전체 난쟁이의 키에서 뺐을 때 100이면 출력한다
 * 재귀를 사용하지 않고 2가지 경우의 수를 출력하므로, 2중 루프가 필요하다
 */
fun main(args: Array<String>) {
    println(`일곱 난쟁이`().solution(intArrayOf(20,7,23,19,10,15,25,8,13)) contentEquals intArrayOf(7,8,10,13,19,20,23))

    try {
        val fn = `일곱 난쟁이`()
        val br = BufferedReader(InputStreamReader(System.`in`))
        val array = IntArray(9)
        for (i in 0..8) {
            array[i] = br.readLine().toInt()
        }
        val result = fn.solution(array)
        for (i in result) {
            println(i)
        }
    } catch (e: IOException) {/* */}
}

class `일곱 난쟁이` {
    fun solution(heights: IntArray):IntArray {
        val total = heights.sum()

        for (i in 0 until heights.size - 1) {
            for (j in i + 1 until heights.size) {
                if (total - (heights[i] + heights[j]) == 100) {
                    return heights.indices
                        .filter { it != i && it != j }
                        .map { heights[it] }
                        .sorted()
                        .toIntArray()
                }
            }
        }

        throw IllegalArgumentException("received heights are invalid")
    }
}