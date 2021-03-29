package baekjoon.datastructure.reference

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/11655
 */
fun main(args: Array<String>) {
    println(ROT13().solution("Baekjoon Online Judge") == "Onrxwbba Bayvar Whqtr")
    println(ROT13().solution("One is 1") == "Bar vf 1")
    println(ROT13().solution("1 2 1") == "1 2 1")
    println(ROT13().solution("1") == "1")
    println(ROT13().solution(" ") == " ")
    println(ROT13().solution("ZZZZZZZZ") == "MMMMMMMM")

    try {
        val fn = ROT13()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(fn.solution(br.readLine()))
    } catch (e: IOException) {/* */}
}

class ROT13 {
    fun solution(str: String): String {
        val result = CharArray(str.length)
        for (i in str.indices) {
            var ROT13 = str[i]
            if (ROT13 in 'a'..'z') {
                ROT13 += 13
                if (ROT13 > 'z') {
                    ROT13 = 'a' + (ROT13 - 1 - 'z')
                }
            } else if (ROT13 in 'A'..'Z') {
                ROT13 += 13
                if (ROT13 > 'Z') {
                    ROT13 = 'A' + (ROT13 - 1 -'Z')
                }
            }

            result[i] = ROT13
        }

        return String(result)
    }
}