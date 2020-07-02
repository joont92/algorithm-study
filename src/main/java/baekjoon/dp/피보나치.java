package baekjoon.dp;

import java.util.function.Supplier;

/**
 * 1부터 시작한다고 가정
 * 1 1 2 3 5 8 13 21 34 55
 */
public class 피보나치 {
    public static void main(String[] args) {
        System.out.println(topDown(10) == 55);
        timer(() -> topDown(10));
        timer(() -> topDown(40));
        timer(() -> topDownWithMemoization(5000));
        timer(() -> bottomUp(5000));
    }

    public static long topDown(int n) {
        if(n <= 2) {
            return 1;
        }

        return topDown(n - 1) + topDown(n - 2);
    }

    static long[] results = new long[10000];
    public static long topDownWithMemoization(int n) {
        if(n <= 2) {
            return 1;
        }

        if(results[n] == 0) {
            results[n] = topDownWithMemoization(n - 1) + topDownWithMemoization(n - 2);
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
