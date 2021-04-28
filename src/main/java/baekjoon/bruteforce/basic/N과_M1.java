package baekjoon.bruteforce.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/15649
 *
 * 순열을 구하는 문제이다(nPr)
 *
 * arr 배열은 하나의 출력마다 사용됨
 * index 0 : 1을 index 1에 기록하고, 사용중 체크하고 넘어감
 * index 1 : 다시 1부터 체크하는데, 1을 이미 사용했으니 2 를 index 1에 기록하고, 사용중 체크하고 넘어감
 * ...
 * index 의 숫자가 뽑고자 하는 숫자의 개수와 같아지면 array 에 있는 배열 출력
 * array 배열은 다음 출력을 위해 또 사용됨
 */
public class N과_M1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N과_M1 fn = new N과_M1();
        int[] param = Arrays.stream(br.readLine().split(" ", 2))
                .mapToInt(Integer::parseInt)
                .toArray();
        fn.solution(0, param[0], param[1]);
    }

    int[] print = new int[9];
    boolean[] check = new boolean[9];

    public void solution(int idx, int n, int m) {
        if(idx == m) {
            System.out.println(Arrays.stream(print)
                    .filter(i -> i > 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(check[i]) {
                continue;
            }

            print[idx] = i;
            check[i] = true;
            solution(idx + 1, n, m);
            check[i] = false;
        }
    }
}