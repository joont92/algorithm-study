package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9095
 *
 * fn(n) = n 을 1,2,3 의 합으로 나타낼 수 있는 경우의 수
 * 앞에 1이 올 경우 = fn(n-1)
 * 앞에 2가 올 경우 = fn(n-2)
 * 앞에 3이 올 경우 = fn(n-3)
 *
 * 이 3가지 경우의 수를 다 합치면 되므로,
 * fn(n) = fn(n-1) + fn(n-2) + fn(n-3)
 *
 * 나열했을 경우
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 1+3
 * 2+1+1
 * 2+2
 * 3+1
 */
public class _1_2_3_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        _1_2_3_더하기 fn = new _1_2_3_더하기();

        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fn.bottomUp(n));
        }
    }

    public int bottomUp(int n) {
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    private int[] dp = new int[11];
    public int topDown(int n) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if(dp[n] == 0) {
            dp[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
        }

        return dp[n];
    }

    public int topDown2(int sum, int n) {
        if(sum > n) {
            return 0;
        }
        if(sum == n) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 3; i++) {
            count += topDown2(sum + i, n);
        }

        return count;
    }
}
