package baekjoon.dp;

/**
 * https://www.acmicpc.net/problem/1463
 *
 * - 일단 연산마다 숫자를 작게 만들어주는 것이 좋다고 생각할 수 있음
 * - 그래서 3으로 먼저 나눠보고, 이후 2로 나눠보고, 이후 1을 뺴는 형태로 계산할 수도 있지만, 이 방법으로는 정답을 구할 수 없음(예시 : 10)
 * - dp 를 사용해야함
 *
 * - 작은 문제로 나눠야 하는데, 문제에 있는 연산을 이용해 나눌 수 있음
 *   - fn(n) = 1 + fn(n/3)
 *   - fn(n) = 1 + fn(n/2)
 *   - fn(n) = 1 + fn(n-3)
 *   > 경우의 수 중 최소값을 구하는 것이므로 위 결과 중 최소값을 찾으면 됨
 *   > 즉, min(3으로 나눈 후 fn(n), 2로 나눈 후 fn(n), 1로 나눈 후 fn(n)) 이 된다
 */

public class _1로_만들기{
    private int[] results;

    public int topDown(int n) {
        if(results == null) results = new int[n + 1];

        if(n <= 1) {
            return 0;
        }

        if(results[n] > 0) {
            return results[n];
        }
        // min 을 구하는 과정(min 이니까 큰 값부터 계산 해야함)
        results[n] = 1 + topDown(n - 1);
        if(n % 2 == 0) {
            results[n] = Math.min(results[n], 1 + topDown(n / 2));
        }
        if(n % 3 == 0) {
            results[n] = Math.min(results[n], 1 + topDown(n / 3));
        }

        return results[n];
    }

    public int bottomUp(int n) {
        int[] results = new int[n + 1];
        results[1] = 0;

        for (int i = 2; i <= n; i++) {
            results[i] = 1 + results[i - 1];
            if(i % 2 == 0) {
                results[i] = Math.min(results[i], 1 + results[i / 2]);
            }
            if(i % 3 == 0) {
                results[i] = Math.min(results[i], 1 + results[i / 3]);
            }
        }

        return results[n];
    }
}