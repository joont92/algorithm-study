package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11726
 *
 * **dp = 더 이상 나눌 수 없는 1단계 + 나머지 단계들**
 *
 * 할 수 있는 가장 최소 행위 : 세로로 1칸 놓기 or 가로로 2칸 놓기
 * 아래서부터 칸을 늘려가며 위의 최소행위들을 수행하게 된다
 * 즉 1칸을 늘렸을 때,
 * 세로로 1칸 추가할 때의 경우의 수(fn(n-1)) + 가로로 2칸 추가할 때의 경우의 수(fn(n-2)) 를 구하면 된다
 * 즉, fn(n) = fn(n-1) + fn(n-2)
 */

public class _2xN_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        _2xN_타일링 a = new _2xN_타일링();
        System.out.println(a.bottomUp(n));
    }

    private int mod = 10_007;

    public int bottomUp(int n) {
        if(n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // dp[i-1], dp[i-2] 가 이미 mod 된 숫자임
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return dp[n];
    }

    private int[] dp;
    public int topDown(int n) {
        if(dp == null) dp = new int[n + 1];

        if(n <= 2) {
            return n;
        }

        if(dp[n] == 0) {
            dp[n] = (topDown(n - 1) + topDown(n - 2)) % mod;
        }

        return dp[n];
    }
}
