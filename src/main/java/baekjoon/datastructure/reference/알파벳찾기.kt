package baekjoon.datastructure.reference

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Collectors

/**
 * https://www.acmicpc.net/problem/10809
 *
 * 문자열을 돌면서 ch - 'a' 인덱스의 자신의 위치를 기록(아직 초기화되지 않은 애들만)
 */
fun main(args: Array<String>) {
    println(알파벳찾기().solution("baekjoon") contentEquals
            intArrayOf(1,0,-1,-1,2,-1,-1,-1,-1,4,3,-1,-1,7,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1))

    try {
        val fn = 알파벳찾기()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(Arrays.stream(fn.solution(br.readLine()))
            .mapToObj { it.toString() }
            .collect(Collectors.joining(" ")));
    } catch (e: IOException) {/* */}
}

class 알파벳찾기 {
    fun solution(str: String): IntArray {
        val result = IntArray(26){ -1 }

        for (i in str.indices) {
            val alphabetIdx = str[i] - 'a';
            if (result[alphabetIdx] == -1) {
                result[alphabetIdx] = i
            }
        }

        return result
    }
}