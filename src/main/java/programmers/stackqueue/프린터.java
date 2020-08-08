package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 프린터 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};

        프린터 fn = new 프린터();
        System.out.println(fn.solution(priorities, 2));
    }

    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));
        }

        int answer = 1;
        while(!queue.isEmpty()) {
            int highestPriority = queue.stream().mapToInt(d -> d.priority).max().getAsInt();
            Document current = queue.peek();

            if(current.priority >= highestPriority) {
                if(current.location == location) {
                    return answer;
                }
                queue.poll();
                answer++;
            } else {
                queue.offer(queue.poll());
            }
        }

        return answer;
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
