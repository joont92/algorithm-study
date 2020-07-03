package baekjoon.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/11052
 *
 * - fn(n) = n 개 카드를 구매할 때 드는 비용의 최대값
 *
 * - 예를 들어 카드를 4개 구매해야 한다고 하면
 *   - 4개짜리 카드덱을 구매했을 떄의 가격
 *   - 3개짜리 카드덱을 구매했을 때 가격 + 카드 1개를 구하기 위해 구매한 카드덱 가격의 최대 값
 *   - 2개짜리 카드덱을 구매했을 때 가격 + 카드 2개를 구하기 위해 구매한 카드덱 가격의 최대 값
 *   - 1개짜리 카드덱을 구매했을 때 가격 + 카드 3개를 구하기 위해 구매한 카드덱 가격의 최대 값
 * - 즉, 위의 결과에서 최대값을 구하면 된다
 *   - max(prices[4] + fn(n-4), prices[3] + fn(n-3), prices[2] + fn(n-2), prices[1] + fn(n-1))
 */
public class 카드_구매하기 {
    private int[] prices;

    public 카드_구매하기(int... n) {
        prices = new int[n.length + 1];
        System.arraycopy(n, 0, prices, 1, n.length);
    }

    public int topDown(int n) {
        if(n == 0) {
            return 0;
        }

        int[] array= new int[n + 1];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = prices[i] + topDown(n - i);

            if(array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}
