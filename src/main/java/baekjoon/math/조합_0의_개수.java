package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2004
 *
 * 조합이란? : https://mathbang.net/547
 * - 순서없이 n 개에서 r 개를 뽑는 경우의 수
 * - nCr = nPr / rPr
 *
 * - nPr 의 5의 개수에서 rPr 의 5의 개수를 뺴주면 되지 않을까?
 */
public class 조합_0의_개수 {
    public int count(long n, long r) {
        return Math.min(
                count(n, 5) - count(r, 5),
                count(n, 5) - count(r, 5)) - count(r, 5);
    }

    public int count(long n, int standard) {
        int count = 0;
        for (int i = standard; i <= n; i *= standard) {
            count += n / i;
        }

        return count;
    }
}
