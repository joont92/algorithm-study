package baekjoon.dp.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10844
 *
 * - `1,2,3 더하기 5` 와 비슷한 방식으로 풀면 된다
 * - fn[n][i] = 마지막에 오는 숫자가 i 일 때, 앞에 계단 숫자가 올 수 있는 경우의 수
 *   > 마지막에 오는 숫자는 0~9 가 되므로
 *   > result = fn[n][0] + fn[n][1] + fn[n][2] + fn[n][3] + fn[n][4] +
 *              fn[n][5] + fn[n][6] + fn[n][7] + fn[n][8] + fn[n][9]
 *
 * - 계단식은 +1, -1 이 가능하므로
 *   > fn[n][i] = fn[n-1][i-1] + fn[n-1][i+1]
 *   > 1글자가 줄어들기 때문에 n-1 이다
 *
 * 1,2,3 더하기5 에서도 봤듯이..
 * 이런식으로 앞의 연산에 영향을 받으면서 다음 연산을 진행해야 할 경우,
 * topDown 보다는 bottomUp 을 활용하는 방향으로 생각하는 것이 좋다
 */
public class 쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        쉬운_계단_수 fn = new 쉬운_계단_수();
        System.out.println(fn.bottomUp(Integer.parseInt(br.readLine())));
    }

    int mod = 1_000_000_000;

    public long bottomUp(int n) {
        long[][] dp = new long[101][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                long plus = j == 9 ? 0 : dp[i - 1][j + 1];
                long minus = j == 0 ? 0 : dp[i - 1][j - 1];

                dp[i][j] = (plus + minus) % mod;
            }
        }

        return Arrays.stream(dp[n]).sum() % mod;
    }
}
