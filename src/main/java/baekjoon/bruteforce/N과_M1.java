package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class N과_M1 {
    private int[] arr = new int[8];
    private boolean[] check = new boolean[8 + 1];

    public void cases(int index, int n, int m) {
        if(index == m) {
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
            arr[index] = i;
            check[i] = true;
            cases(index + 1, n, m);
            check[i] = false;
        }
    }
}