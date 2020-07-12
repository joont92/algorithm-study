package baekjoon.dp;

/**
 * https://www.acmicpc.net/problem/11726
 *
 * - dp = 더 이상 나눌 수 없는 1단계 + 나머지 단계들
 * - 오른쪽 끝에 타일을 2x1 타일을 하나 놓거나(fn(n-1)), 1x2 타일을 2개 놓는게(fn(n-2)) 가장 작은 단계 2개
 * - 모든 경우의 수를 구하는 것이므로 합을 구하면 됨
 * - 즉, fn(n) = fn(n-1) + fn(n-2)
 */
public class _2xN_타일링 {
    int mod = 10007;
    private int[] array;

    public int topDown(int n) {
        if(array == null) array = new int[n + 1];

        if(n <= 2) {
            return n;
        }

        if(array[n] == 0) {
            array[n] = (topDown(n - 1) + topDown(n - 2)) % mod;
        }

        return array[n];
    }

    public int bottomUp(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % mod;
        }

        return array[n];
    }
}
