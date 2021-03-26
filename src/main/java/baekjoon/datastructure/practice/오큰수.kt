package baekjoon.datastructure.practice

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Collectors

/**
 * https://www.acmicpc.net/problem/17298
 *
 * 앞에서부터 스택에 하나씩 더하면서
 * 현재 숫자가 스택에 있는 숫자보다 클 경우 result에 추가한다(작은 숫자가 나온다면 계속 스택에서 뺸다)
 * 현재 숫자가 작으면 스택에 더하고 다음 숫자로 넘어간다
 */

class 오큰수 {
    // stack에 숫자 대신 index 값을 넣으면 코드를 더 줄일 수 있다
    fun solution(numbers: IntArray): IntArray {
        val result = IntArray(numbers.size)

        val stack = Stack<Element>()
        stack.push(Element(0, numbers[0]))

        for (i in 1 until numbers.size) {
            val number = numbers[i]

            while (!stack.isEmpty() && number > stack.peek().number) {
                result[stack.pop().idx] = number
            }

            stack.push(Element(i, number))
        }

        while (!stack.isEmpty()) {
            result[stack.pop().idx] = -1
        }
        result[numbers.size - 1] = -1

        return result
    }

    class Element(val idx:Int, val number:Int)
}

fun main(args: Array<String>) {
    println(오큰수().solution(intArrayOf(1,2,3,4)) contentEquals intArrayOf(2,3,4,-1))
    println(오큰수().solution(intArrayOf(3,5,2,7)) contentEquals intArrayOf(5,7,7,-1))
    println(오큰수().solution(intArrayOf(3,2,2,7)) contentEquals intArrayOf(7,7,7,-1))
    println(오큰수().solution(intArrayOf(5,8,4,7,10)) contentEquals intArrayOf(8,10,7,10,-1))
    println(오큰수().solution(intArrayOf(9,5,4,8)) contentEquals intArrayOf(-1,8,8,-1))
    println(오큰수().solution(intArrayOf(9,9,9,9)) contentEquals intArrayOf(-1,-1,-1,-1))
    println(오큰수().solution(intArrayOf(1,100,3,200,400,300)) contentEquals intArrayOf(100,200,200,400,-1,-1))
    println(오큰수().solution(intArrayOf(1)) contentEquals intArrayOf(-1))

    val fn = 오큰수()
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