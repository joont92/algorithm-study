package baekjoon.dp;

/**
 * https://www.acmicpc.net/problem/9095
 *
 * - fn(n) = n 을 1,2,3 의 합으로 나타내는 경우의 수
 * - 나열해보면 점화식을 구할 수 있다
 *   1+1+1+1
 *   1+1+2
 *   1+2+1
 *   1+3
 *   > 앞에 1이 오는 경우의 수 == fn(n-1) 의 경우의 수
 *   2+1+1
 *   2+2
 *   > 앞에 2가 오는 경우의 수 == fn(n-2) 의 경우의 수
 *   3+1
 *   > 앞에 3이 오는 경우의 수 == fn(n-3) 의 경우의 수
 * - 즉, 위의 3가지 경우의 수를 다 합치면 된다
 *   - fn(n) = fn(n-1) + fn(n-2) + fn(n-3)
 */
public class _1_2_3_더하기 {
    private int[] array = new int[11];
    public int topDown(int n) {
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        if(array[n] == 0) {
            array[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);
        }

        return array[n];
    }

    public int bottomUp(int n) {
        int[] array = new int[11];
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i <= n; i++) {
            array[i] = array[n - 1] + array[n - 2] + array[n - 3];
        }

        return array[n];
    }
}
