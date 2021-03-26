package baekjoon.datastructure.practice

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.HashMap

/**
 * https://www.acmicpc.net/problem/17299
 *
 * 숫자별 빈도수를 map에 전부 넣음
 * 배열의 뒤에서부터 순회하면서 스택에 넣으면서 비교한다
 * 앞의 숫자에 대한 후보군이 스택에 계속 쌓이는 것
 * 뒤에서 앞으로 순회하면서, 후보군 스택에 있는 숫자를 하나씩 빼면서 자기보다 많이 출현한 숫자를 결과에 쓴다
 */
fun main(args: Array<String>) {
    println(오등큰수().solution(intArrayOf(1,1,2,3,4,2,1)) contentEquals intArrayOf(-1,-1,1,2,2,1,-1))
    println(오등큰수().solution(intArrayOf(1,1,1)) contentEquals intArrayOf(-1,-1,-1))
    println(오등큰수().solution(intArrayOf(1)) contentEquals intArrayOf(-1))
    println(오등큰수().solution(intArrayOf(1,2,3)) contentEquals intArrayOf(-1,-1,-1))
    println(오등큰수().solution(intArrayOf(3,2,2,1,1,1)) contentEquals intArrayOf(2,1,1,-1,-1,-1))

    val fn = 오등큰수()
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()

        val result = fn.solution(br.readLine().split(" ").stream()
            .mapToInt { s -> s.toInt() }
            .toArray())

        println(Arrays.stream(result)
            .mapToObj { i -> i.toString() }
            .collect(Collectors.joining(" ")))
    } catch (e: Exception) { /* */ }
}

class 오등큰수 {
    fun solution(numbers: IntArray): IntArray {
        val result = IntArray(numbers.size) {-1}

        val map = HashMap<Int, Int>()
        for (number in numbers) {
            map[number] = map.getOrDefault(number, 0) + 1
        }

        val stack = Stack<Int>()
        stack.push(numbers[numbers.size - 1])

        for (i in numbers.size - 2 downTo 0) {
            while (!stack.isEmpty()) {
                if (map[numbers[i]]!! < map[stack.peek()]!!) {
                    result[i] = stack.peek()
                    break
                } else {
                    stack.pop()
                }
            }
            stack.push(numbers[i])
        }

        return result
    }
}