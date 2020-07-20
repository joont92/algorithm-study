package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2004
 *
 * 조합이란? : https://mathbang.net/547
 * - 순서없이 n 개에서 r 개를 뽑는 경우의 수
 * - nCr = nPr / rPr
 * - nCr = n! / r! * (n-r)!
 *
 * 분자 min(2,5)의 개수에서 분모 min(2,5)의 개수만큼 뺴주면 된다
 */
public class 조합_0의_개수 {
    public int count(long n, long r) {
        return Math.min(
                countInternal(n, 5) - countInternal(r, 5) - countInternal(n - r, 5),
                countInternal(n, 2) - countInternal(r, 2) - countInternal(n - r, 2));
    }

    private int countInternal(long n, int standard) {
        int count = 0;
        for (long i = standard; i <= n; i *= standard) {
            count += n / i;
        }

        return count;
    }
}
