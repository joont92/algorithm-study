package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1158
 *
 * 큐의 첫번째 인자를 마지막 인자로 넣어주는 행위를 계속 하다가
 * 제거하고자 하는 순서가 되었을 때 큐의 마지막에 넣어주지 않고 제거하면 된다
 */
public class 요세푸스_문제 {
    public int[] solution(int n, int k) {
        var result = new ArrayList<Integer>();

        var queue = new LinkedList<Integer>();
        IntStream.rangeClosed(1, n)
                .forEach(queue::offer);

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            result.add(queue.poll());
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
//        basic();
        System.out.println(Arrays.equals(
                new 요세푸스_문제().solution(7, 3),
                new int[]{3,6,2,7,5,1,4}));

        System.out.println(Arrays.equals(
                new 요세푸스_문제().solution(1, 3),
                new int[]{1}));
    }

    private static void basic() {
        var fn = new 요세푸스_문제();

        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            var str = br.readLine().split(" ");
            Arrays.stream(fn.solution(Integer.parseInt(str[0]), Integer.parseInt(str[1])))
                    .forEach(System.out::println);
        } catch (IOException e) {
            //
        }
    }
}
