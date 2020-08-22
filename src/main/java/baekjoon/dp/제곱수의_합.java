package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1699
 *
 * 최대로 올 수 있는 제곱수는 루트 n 의 제곱이다
 * 루트 n 부터 1까지 -- 연산을 하며 아래의 점화식을 적용한다
 *
 * fn(n) = 1 + fn(n - i^2)
 * > 1 은 i^2 를 뜻함
 * > 정답은 개수를 구하는 것이니, 1로 표시
 *
 * 이 중에서 최소값을 구하면 된다
 */
public class 제곱수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        제곱수의_합 fn = new 제곱수의_합();
        System.out.println(fn.bottomUp(Integer.parseInt(br.readLine())));
    }

    int[] dp = new int[100_001];
    public int topDown(int n) {
        if(n <= 3) {
            return n;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int min = n;

        int sqrt = (int) Math.sqrt(n);
        for (int i = sqrt; i >= 2; i--) { // 1은 아무것도 안한거나 마찬가지라 제외해도 됨
            min = Math.min(min, 1 + topDown(n - i * i));
        }
        dp[n] = min;

        return min;
    }

    /*
    처음에는 dp[i] = i 로 숫자 N에 대한 제곱수 합의 최대값을 설정하고(전부 1로만 이루어져 있음),
    이후 dp[i] 에서 제곱수만큼 깎아나가며 더 작은값을 계속 세팅해나가는 방법이다
     */
    public int bottomUp(int n) {
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
