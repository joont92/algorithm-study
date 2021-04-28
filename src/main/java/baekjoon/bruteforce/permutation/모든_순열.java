package baekjoon.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/10974
 *
 * N과M 문제와 동일함
 */
public class 모든_순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        모든_순열 fn = new 모든_순열();
        fn.allPermutation(0, Integer.parseInt(br.readLine()));
    }

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
