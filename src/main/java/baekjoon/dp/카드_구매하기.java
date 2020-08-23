package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/11052
 *
 * - fn(n) = n 개 카드를 구매할 때 드는 비용의 최대값
 *
 * - 예를 들어 카드를 4개 구매해야 한다고 하면
 *   - 4개짜리 카드덱을 구매했을 때의 가격
 *   - 3개짜리 카드덱을 구매했을 때 가격 + 카드 1개를 구하기 위해 구매한 카드덱 가격의 최대 값
 *   - 2개짜리 카드덱을 구매했을 때 가격 + 카드 2개를 구하기 위해 구매한 카드덱 가격의 최대 값
 *   - 1개짜리 카드덱을 구매했을 때 가격 + 카드 3개를 구하기 위해 구매한 카드덱 가격의 최대 값
 * - 즉, 위의 결과에서 최대값을 구하면 된다
 *   - max(fn(n-i) + pricesZ[i]))
 *
 * - 시간 복잡도는 O(n^2) 가 된다
 *   - n을 받으면 1~n 까지 반복(O(n))을 돌고, 이것을 n 이 0이 될때까지(O(n)) 하니 O(n^2) 이다
 */
public class 카드_구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        카드_구매하기 fn = new 카드_구매하기(Arrays.stream(br.readLine().split(" ", n))
                .mapToInt(Integer::parseInt)
                .toArray());
        System.out.println(fn.bottomUp(n));
    }

    int[] prices;
    public 카드_구매하기(int[] args) {
        this.prices = new int[args.length + 1];
        System.arraycopy(args, 0, this.prices, 1, args.length);
    }

    /*
    array[1] = 카드 1개 구매할 때 최대 비용
    array[2] = 카드 2개 구매할 때 최대 비용
    array[3] = 카드 3개 구매할 때 최대 비용
    ...
     */
    public int bottomUp(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];

            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j] + dp[i - j]);
            }
        }

        return dp[n];
    }


    // 매 함수마다 배열이 따로 생성되고
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
