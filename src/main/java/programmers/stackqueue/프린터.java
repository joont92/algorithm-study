package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 * queue 를 활용하면 됨
 * 앞에서부터 뽑는데, 자기보다 우선순위가 높은 숫자가 있을 경우 자신을 큐의 가장 뒤로 넣는다
 * 우선순위가 가장 높은 숫자의 경우 큐에서 빼면서 count++ 한다
 * 뽑을 때 요청했던 location과 같다면 count를 반환한다
 */
public class 프린터 {
    public static void main(String[] args) {
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};

        프린터 fn = new 프린터();
        System.out.println(fn.solution(priorities, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Document> queue = IntStream.range(0, priorities.length)
                .mapToObj(i -> new Document(i, priorities[i]))
                .collect(Collectors.toCollection(LinkedList::new));

        // 매번 max 를 구해도 됨
        Arrays.sort(priorities);
        int maxIdx = priorities.length - 1;

        while (!queue.isEmpty()) {
            Document latest = queue.peek();

            if(latest.priority >= priorities[maxIdx]) {
                queue.poll();
                maxIdx--;
                answer++;

                if(latest.location == location) {
                    return answer;
                }
            } else {
                queue.offer(queue.poll());
            }
        }

        throw new IllegalArgumentException();
    }

    class Document {
        int location;
        int priority;

        public Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}
