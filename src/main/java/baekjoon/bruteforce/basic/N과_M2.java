package baekjoon.bruteforce.basic;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/15650
 *
 * 나열할 수가 이전에 나열한 수보다 작으면 skip 한다
 */
public class N과_M2 {
    private int[] arr = new int[8];
    private boolean[] check = new boolean[8 + 1];

    public void cases(int index, int n, int m) {
        if(m == index) {
            System.out.println(Arrays.stream(arr)
                    .filter(i -> i > 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(check[i]) {
                continue;
            }
            if(index >= 1 && arr[index - 1] > i) {
                continue;
            }

            check[i] = true;
            arr[index] = i;
            cases(index + 1, n, m);
            check[i] = false;
        }
    }
}
