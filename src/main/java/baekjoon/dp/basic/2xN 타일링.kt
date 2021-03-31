package baekjoon.dp.basic

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/11726
 *
 * f(n) : 2x1, 1x2로 타일을 채룰 수 있는 방법의 수
 * 끝에 놓을 수 있는 타일의 모습 : 2x1 타일 1개 놓기, 1x2 타일 2개 놓기
 * 끝에 2x1 타일을 놓았을 경우 n이 1칸 줄어들었으므로 f(n-1)
 * 끝에 1x2 타일을 놓았을 경우 n이 2칸 줄어들었으므로 f(n-2)
 * 2개를 단순히 합치면 된다(끝에 2x1타일 1개 놓았을때와 1x2 타일 2개 놓았을때의 모양은 서로 다르므로)
 *
 * 점화식 : f(n) = f(n-1) + f(n-2)
 */
fun main(args: Array<String>) {
    println(`2xN 타일링`().solution(2) == 2)
    println(`2xN 타일링`().solution(9) == 55)
    println(`2xN 타일링`().solution(1) == 1)

    try {
        val fn = `2xN 타일링`()
        val br = BufferedReader(InputStreamReader(System.`in`));
        println(fn.solution(br.readLine().toInt()))
    } catch (e: IOException) {/* */}
}

class `2xN 타일링` {
    fun solution(n: Int): Int {
        if (n <= 1) {
            return n
        }

        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {
            // 앞 숫자에 % 연산이 적용되더라도, (a + b) % c == ((a % c) + (b % c)) % c 이기 때문에 괜찮음
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007
        }

        return dp[n]
    }
}