package baekjoon.datastructure.reference;

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Collectors

/**
 * https://www.acmicpc.net/problem/10808
 *
 * 26개의 배열을 선언하고, ch - 'a' 으로 인덱스를 찾아가 ++
 */
fun main(args: Array<String>) {
    println(알파벳개수().solution("baekjoon") contentEquals
            intArrayOf(1,1,0,0,1,0,0,0,0,1,1,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0))
    try {
        val fn = 알파벳개수()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(Arrays.stream(fn.solution(br.readLine()))
            .mapToObj { it.toString() }
            .collect(Collectors.joining(" ")));
    } catch (e: IOException) {/* */}
}

class 알파벳개수 {
    fun solution(str: String): IntArray {
        val result = IntArray(26){ 0 }

        for (c in str.toCharArray()) {
            result[c - 'a']++
        }

        return result
    }
}