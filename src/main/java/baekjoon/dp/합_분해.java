package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2225
 *
 * 정수 k 개의 합으로 n 을 구하는 방법은
 * 정수 k-1 개의 합으로 n-i 를 구하는 합과 같다
 * n-i 에다가 i를 더해주면 되기 떄문이다(k 1개 증가)
 * > fn(k)(n) = fn(k-1)(n-i) // 0 <= i <= n
 *
 * [4][6] = [3][0]+[3][1]+[3][2]+[3][3]+[3][4]+[3][5]+[3][6]
 * > 0 과 6을 더해주는건 0 + 6, 6 + 0 도 연산에 포함되기 때문이다
 */
public class 합_분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        합_분해 fn = new 합_분해();
        int[] param = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(fn.operationCount(param[1], param[0]));
    }

    private int mod = 1_000_000_000;

    public int operationCount(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i - 1][l] % mod;
                }
            }
        }

        return dp[k][n] % mod;
    }
}
