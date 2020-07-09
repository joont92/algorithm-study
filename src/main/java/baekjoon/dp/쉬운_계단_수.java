package baekjoon.dp;

import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/10844
 *
 * - `1,2,3 더하기 5` 와 비슷한 방식으로 풀면 된다
 * - fn[n][i] = 마지막에 오는 숫자가 i 일 때, 앞에 계단 숫자가 올 수 있는 경우의 수
 *   > 마지막에 오는 숫자는 0~9 가 되므로
 *   > result = fn[n][0] +fn[n][1] +fn[n][2] +fn[n][3] +fn[n][4] +fn[n][5] +fn[n][6] +fn[n][7] +fn[n][8] +fn[n][9]
 *   
 * - 계단식은 +1, -1 이 가능하므로
 *   > fn[n][i] = fn[n-1][i-1] + fn[n-1][i+1]
 */
public class 쉬운_계단_수 {
    public long bottomUp(int n) {
        int mod = 1_000_000_000;
        long[][] array = new long[101][10];
        for (int i = 1; i <= 9; i++) {
            array[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                // 0 -> 9 는 없다
                if(j == 0) {
                    array[i][j] = array[i - 1][j + 1] % mod;
                } else if(j == 9) {
                    array[i][j] = array[i - 1][j - 1] % mod;
                } else {
                    array[i][j] = (array[i - 1][j + 1] + array[i - 1][j - 1]) % mod;
                }
            }
        }

        return IntStream.rangeClosed(0, 9)
                .mapToLong(i -> array[n][i])
                .reduce(0, Long::sum) % mod;
    }
}
