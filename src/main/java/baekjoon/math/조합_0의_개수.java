package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/2004
 *
 * 순열이란? : https://mathbang.net/545
 * - n 개에서 r 개를 순서대로 뽑는 경우의 수
 * - 10개에서 3개를 순서대로 뽑는다고 하면,
 *   - 처음에는 경우의 수 10, 다음에는 경우의 수 9, 다음에는 경우의 수 8
 *   - 같이 일어나는 경우의 수니 곱의 법칙을 적용해서 10 x 9 x 8
 * - nPr = n! / (n-r)!
 *
 * 조합이란? : https://mathbang.net/547
 * - 순서없이 n 개에서 r 개를 뽑는 경우의 수
 * - nCr * rPr = nPr
 * - nCr = nPr / rPr
 * - nCr = n! / r! * (n-r)!
 *       = n * (n-1) ... (n-r) / r!
 *
 * - n! 의 0의 개수 - r! 의 0의 개수 - (n-r)! 의 0의 개수
 *   - 분수로 나타내서 위아래로 0을 삭제하는 과정을 생각하면 된다
 * - 0의 개수는 `팩토리얼 0의 개수` 처럼 5의 배수 개수를 뺴주면 된다
 *   - `조합 0의 개수` 의 경우 2의 배수가 더 많은 경우도 있기 때문에, min(5의 배수 개수, 2의 배수 개수) 를 구해줘야 한다
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
