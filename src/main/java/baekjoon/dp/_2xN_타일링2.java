package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11727
 *
 * 할 수 있는 최소 행위
 * - 세로 타일 1개 놓기 = fn(n-1)
 * - 가로 타일 2개 놓기 = fn(n-2)
 * - 정사각형 타일 1개 놓기 = fn(n-2)
 * 즉, fn(n) = fn(n-1) + fn(n-2) + fn(n-2)
 */
public class _2xN_타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        _2xN_타일링2 a = new _2xN_타일링2();
        System.out.println(a.bottomUp(n));
    }

    private int mod = 10_007;

    public int bottomUp(int n) {
        if(n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % mod;
        }

        return dp[n];
    }
}
