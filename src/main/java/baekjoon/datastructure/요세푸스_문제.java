package baekjoon.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.acmicpc.net/problem/1158
 *
 * 큐의 첫번째 인자를 마지막 인자로 넣어주는 행위를 계속 하다가
 * 제거하고자 하는 순서가 되었을 때 큐의 마지막에 넣어주지 않고 제거하면 된다
 */
public class 요세푸스_문제 {
    public List<Integer> removedOrder(int n, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (queue.size() > 0) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }

        return result;
    }
}
