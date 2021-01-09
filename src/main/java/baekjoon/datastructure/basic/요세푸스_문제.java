package baekjoon.datastructure.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1158
 *
 * 큐의 첫번째 인자를 마지막 인자로 넣어주는 행위를 계속 하다가
 * 제거하고자 하는 순서가 되었을 때 큐의 마지막에 넣어주지 않고 제거하면 된다
 */
public class 요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        요세푸스_문제 fn = new 요세푸스_문제();
        fn.solution(n, k).forEach(System.out::println);
    }

    private List<Integer> solution(int n, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(queue::offer);

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            result.add(queue.poll());
        }

        return result;
    }
}
