package baekjoon.dp.basic;

import java.util.function.Supplier;

/**
 * 1부터 시작한다고 가정
 * 1 1 2 3 5 8 13 21 34 55
 *
 * - 시간 복잡도는 O(n) 이 된다
 *   - bottomUp 의 경우 전달한 인자 n 번 만큼만 연산(반복문)을 수행하고
 *   - topDown 의 경우 n 이 늘어나면서 했던 연산을 또 하긴 하지만 memoization 때문에 추가 연산을 하지 않기 때문이다
 */
public class 피보나치 {
    public static void main(String[] args) {
        System.out.println(topDownWithoutMemoization(10) == 55);
        timer(() -> topDownWithoutMemoization(10));
        timer(() -> topDownWithoutMemoization(40));
        timer(() -> topDown(5000));
        timer(() -> bottomUp(5000));
    }

    public static long topDownWithoutMemoization(int n) {
        if(n <= 2) {
            return 1;
        }

        return topDownWithoutMemoization(n - 1) + topDownWithoutMemoization(n - 2);
    }

    static long[] results = new long[10000];
    public static long topDown(int n) {
        if(n <= 2) {
            return 1;
        }

        if(results[n] == 0) {
            results[n] = topDown(n - 1) + topDown(n - 2);
        }
        return results[n];
    }

    public static long bottomUp(int n) {
        long[] results = new long[n + 1];
        results[1] = 1;
        results[2] = 1;

        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }

    private static void timer(Supplier<Long> supplier) {
        long start = System.currentTimeMillis();
        System.out.println("result : " + supplier.get());
        long end = System.currentTimeMillis();

        System.out.println(end - start + " ms");
    }
}
