package baekjoon.dp.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2193
 *
 * n 자리 이친수는
 * - n 번쨰 숫자가 0인 경우 == n-1 자리 이친수에서 뒷자리가 0 + n-1 자리 이친수에서 뒷자리가 1
 * - n 번쨰 숫자가 1인 경우 == n-1 자리 이친수에서 뒷자리가 0
 * 이 2개를 더하면 된다
 */
public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        이친수 fn = new 이친수();
        System.out.println(fn.bottomUp(Integer.parseInt(br.readLine())));
    }

    public int bottomUp(int n) {
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        return dp[n][0] + dp[n][1];
    }
}
