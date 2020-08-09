package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 앞에서 2개씩 더해서 priority queue 에 넣어주면 매번 정렬된다
 * 작은 수 부터 정렬되므로 가장 앞 숫자가 스코빌 지수보다 낮은지만 검사하면 된다
 */
public class 더_맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};

        더_맵게 fn = new 더_맵게();
        System.out.println(fn.solution(scoville, 7));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue =
                Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        if(priorityQueue.peek() >= K) {
            return 0;
        }

        int answer = 0;
        while (priorityQueue.size() >= 2 && priorityQueue.peek() < K) {
            priorityQueue.offer(priorityQueue.poll() + (priorityQueue.poll() * 2));
            answer++;
        }

        return priorityQueue.peek() < K ? -1 : answer;
    }
}
