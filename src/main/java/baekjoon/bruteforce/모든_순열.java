package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/10974
 */
public class 모든_순열 {
    int[] arr = new int[8];
    boolean[] check = new boolean[8 + 1];

    public void allPermutation(int index, int n) {
        if(index == n) {
            System.out.println(Arrays.stream(arr)
                    .filter(e -> e > 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(check[i]) {
                continue;
            }

            check[i] = true;
            arr[index] = i;
            allPermutation(index + 1, n);
            check[i] = false;
        }
    }
}
