package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1463
 *
 * - 일단 연산마다 숫자를 작게 만들어주는 것이 좋다고 생각할 수 있음
 * - 그래서 3으로 먼저 나눠보고, 이후 2로 나눠보고, 이후 1을 뺴는 형태로 계산할 수도 있지만, 이 방법으로는 정답을 구할 수 없음(예시 : 10)
 * - dp 를 사용해야함
 *
 * - **DP 의 기본은 마지막 1문제를 구하는 것이고, 그 문제를 이용해 전체 문제의 답을 구하는 것이다**
 *
 * - 작은 문제로 나눠야 하는데, 문제에 있는 연산을 이용해 나눌 수 있음
 *   - fn(n) = n 을 1로 만들 떄 쓰이는 최소 연산 횟수
 *   - fn(n) = 1 + fn(n/3)
 *   - fn(n) = 1 + fn(n/2)
 *   - fn(n) = 1 + fn(n-1)
 *   > 연산의 횟수 이므로 /3, /2, -1 도 연산으로 보기 때문에 + 1을 매번 해줘야 함
 *
 * 경우의 수 중 최소값을 구하는 것이므로 위 결과 중 최소값을 찾으면 됨
 * 즉, min(1 + fn(n/3), 1 + fn(n/2), 1 + fn(n-1)) 이 된다
 */

public class _1로_만들기{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        _1로_만들기 o = new _1로_만들기();
        System.out.println(o.bottomUp(n));
    }

    public int bottomUp(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
        }

        return dp[n];
    }

    private int[] dp;
    public int topDown(int n) {
        if(dp == null) dp = new int[n + 1];

        if(n <= 1) {
            return 0;
        }

        if(dp[n] > 0) {
            return dp[n];
        }
        // min 을 구하는 과정(min 이니까 큰 값부터 계산 해야함)
        dp[n] = 1 + topDown(n - 1);
        if(n % 2 == 0) {
            dp[n] = Math.min(dp[n], 1 + topDown(n / 2));
        }
        if(n % 3 == 0) {
            dp[n] = Math.min(dp[n], 1 + topDown(n / 3));
        }

        return dp[n];
    }
}
