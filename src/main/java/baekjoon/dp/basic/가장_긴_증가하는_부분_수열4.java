package baekjoon.dp.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/14002
 *
 * 역추적 과정이 필요함
 * lis 에 값이 저장될 때 마다 어떤 lis 를 참조했는지 배열에 기록하고, 마지막에 이를 역추적해서 출력하면 된다
 */
public class 가장_긴_증가하는_부분_수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        가장_긴_증가하는_부분_수열4 fn = new 가장_긴_증가하는_부분_수열4();

        fn.lis(Arrays.stream(br.readLine().split(" ", count))
                .mapToInt(Integer::parseInt)
                .toArray());
    }

    public void lis(int... sequence) {
        int[] tracking = new int[sequence.length];
        Arrays.fill(tracking, -1);

        int[] lis = new int[sequence.length];
        Arrays.fill(lis, 1);

        for (int i = 1; i < sequence.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(sequence[i] > sequence[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    tracking[i] = j;
                }
            }
        }

        int max = Arrays.stream(lis).max().getAsInt();
        System.out.println(max);

        int startIdx = IntStream.range(0, lis.length)
                .filter(i -> lis[i] == max)
                .findFirst()
                .getAsInt();

        List<Integer> print = new ArrayList<>();
        do {
            print.add(sequence[startIdx]);
            startIdx = tracking[startIdx];
        } while (startIdx != -1);

        Collections.reverse(print);
        System.out.println(print.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
