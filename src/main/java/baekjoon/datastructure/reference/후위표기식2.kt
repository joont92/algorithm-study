package baekjoon.datastructure.reference

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/**
 * https://www.acmicpc.net/problem/1935
 *
 * 숫자일 경우 스택에 넣고, 연산자일 경우 스택에서 2개 빼서 연산한 뒤 다시 스택에 넣음
 * 최종적으로 스택에 남은 값을 반환하면 됨
 */

fun main(args: Array<String>) {
    println(후위표기식2().solution(listOf("1","2","3","*","+","4","5","/","-")) == 6.2)
    println(후위표기식2().solution(listOf("1","1","+","1","+")) == 3.0)
    println(후위표기식2().solution(listOf("1","2","*","1","+","3","-","2","+")) == 2.0)
    println(후위표기식2().solution(listOf("12","13","+")) == 25.0)

    val fn = 후위표기식2()
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val count = br.readLine().toInt()

        val originExpression = br.readLine()
        val convertedExpression = ArrayList<String>()
        val numbers = IntArray(count)
        for (i in 0 until count) {
            numbers[i] = br.readLine().toInt()
        }

        for (i in originExpression.indices) {
            if ("+-*/".indexOf(originExpression[i]) != -1) {
                convertedExpression.add(originExpression[i].toString())
            } else {
                convertedExpression.add(numbers[originExpression[i] - 'A'].toString())
            }
        }

        println("%.2f".format(fn.solution(convertedExpression)))
    } catch (e: Exception) { e.printStackTrace() }
}

class 후위표기식2 {
    fun solution(expression: List<String>): Double {
        val stack = Stack<Double>()

        for (str in expression) {
            if ("+-*/".indexOf(str) != -1) {
                val second = stack.pop().toString().toDouble()
                val first = stack.pop().toString().toDouble()

                when (str) {
                    "+" -> stack.push(first + second)
                    "-" -> stack.push(first - second)
                    "*" -> stack.push(first * second)
                    "/" -> stack.push(first / second)
                }
            } else {
                stack.push(str.toDouble())
            }
        }

        return stack.pop()
    }
}