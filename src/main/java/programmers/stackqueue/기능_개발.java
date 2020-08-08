package programmers.stackqueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * 기능들을 하루 단위로 speed 만큼 + 하고,
 * 하루가 끝난 뒤 앞에서부터 100 이 넘는 애들을 poll 한다
 */
public class 기능_개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        기능_개발 fn = new 기능_개발();

        int[] result = fn.solution(progresses, speeds);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        LinkedList<Integer> progressesQueue = Arrays.stream(progresses)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> speedsQueue = Arrays.stream(speeds)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (!progressesQueue.isEmpty()) {
            for (int i = 0; i < progressesQueue.size(); i++) {
                progressesQueue.set(i, progressesQueue.get(i) + speedsQueue.get(i));
            }

            int deployCount = 0;
            while (!progressesQueue.isEmpty() && progressesQueue.getFirst() >= 100) {
                progressesQueue.poll();
                speedsQueue.poll();
                deployCount++;
            }
            if(deployCount > 0) {
                answer.add(deployCount);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
