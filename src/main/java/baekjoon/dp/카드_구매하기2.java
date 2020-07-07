package baekjoon.dp;

/**
 * https://www.acmicpc.net/problem/16194
 *
 */
public class 카드_구매하기2 {
    private int[] prices;

    public 카드_구매하기2(int... n) {
        prices = new int[n.length + 1];
        System.arraycopy(n, 0, prices, 1, n.length);
    }

    public int bottomUp(int n) {
        int[] array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                array[i] = array[i] == 0 ? array[i - j] + prices[j] : Math.min(array[i - j] + prices[j], array[i]);
            }
        }

        return array[n];
    }
}
