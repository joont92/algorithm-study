package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/16194
 *
 */
public class 카드_구매하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        카드_구매하기2 fn = new 카드_구매하기2(Arrays.stream(br.readLine().split(" ", n))
                .mapToInt(Integer::parseInt)
                .toArray());
        System.out.println(fn.bottomUp(n));
    }

    private int[] prices;

    public 카드_구매하기2(int... n) {
        prices = new int[n.length + 1];
        System.arraycopy(n, 0, prices, 1, n.length);
    }

    public int bottomUp(int n) {
        int[] array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = prices[i];
            for (int j = 1; j < i; j++) {
                array[i] = Math.min(array[i - j] + prices[j], array[i]);
            }
        }

        return array[n];
    }
}
