package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/15654
 *
 * N과M1 과 비슷하다
 * 1부터 n 까지 순서대로 증가하는 숫자 대신 전달받은 배열을 사용하면 된다
 */
public class N과_M5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] param = Arrays.stream(br.readLine().split(" ", 2))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] array = Arrays.stream(br.readLine().split(" ", param[0]))
                .mapToInt(Integer::parseInt)
                .toArray();

        N과_M5 fn = new N과_M5(array, param[1]);
        fn.cases(0, param[1]);
    }

    private int[] array;
    private boolean[] check;
    private int[] print;

    public N과_M5(int[] array, int m) {
        Arrays.sort(array);
        this.array = array;
        this.check = new boolean[10_001];
        this.print = new int[m];
    }

    public void cases(int idx, int m) {
        if(idx == m) {
            System.out.println(Arrays.stream(print)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int value : array) {
            if (check[value]) {
                continue;
            }

            check[value] = true;
            print[idx] = value;
            cases(idx + 1, m);
            check[value] = false;
        }
    }
}
