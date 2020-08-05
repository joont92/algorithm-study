package baekjoon.dp;

/**
 * https://www.acmicpc.net/problem/2193
 *
 * - n 자리 숫자 이친수는 n-1 자리 숫자 이친수에서 뒷자리가 0일 경우 +2, 1일 경우 +1 한 개수들의 합이다
 *
 * 예를 들어 4자리 숫자의 이친수를 구해야한다고 할 때, 3자리 숫자 이친수는 아래와 같다
 * 100
 * 101
 *
 * 뒷자리가 0일 경우 뒤에 0과 1이 올 수 있으므로, +2를 해주면 된다(1000, 1001)
 * 뒷자리가 1일 경우 뒤에 0만 올 수 있으므로, +1을 해주면 된다(1010)
 *
 * n 자리 이친수에서
 * - n 번쨰 숫자가 0인 경우 == n-1 자리 이친수에서 뒷자리가 0 + n-1 자리 이친수에서 뒷자리가 1
 * - n 번쨰 숫자가 1인 경우 == n-1 자리 이친수에서 뒷자리가 0
 * 그리고 이 2개를 더하면 된다
 */
public class 이친수 {
    public long bottomUp(int n) {
        long[][] array = new long[n + 1][2];
        array[1][0] = 0;
        array[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i][0] = array[i - 1][0] + array[i - 1][1];
            array[i][1] = array[i - 1][0];
        }

        return array[n][0] + array[n][1];
    }
}
