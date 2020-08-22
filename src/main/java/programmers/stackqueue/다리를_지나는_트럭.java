package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 * 다리에 올라갈 수 있는 트럭을 한번에 쭉 넣고
 * 아래에서 하나씩 깎아가며 +1초 또는 +length초
 */
public class 다리를_지나는_트럭 {
    /*
    1	2	[1, 1, 1]	4
    1	1	[1, 1, 1]	4
    4	2	[1, 1, 1, 1]	10
    3	3	[1, 1, 1]	6
    3	1	[1, 1, 1]	10
    5	5	[1, 1, 1, 1, 1, 2, 2]	14
    7	7	[1, 1, 1, 1, 1, 3, 3]	18
    5	5	[1, 1, 1, 1, 1, 2, 2, 2, 2]	19
    5	5	[2, 2, 2, 2, 1, 1, 1, 1, 1]	19
     */
    public static void main(String[] args) {
        int[] truckWeights = {7,4,5,6};
//        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};
//        int[] truckWeights = {1,1,1,1};

        다리를_지나는_트럭 fn = new 다리를_지나는_트럭();
        System.out.println(fn.solution(2, 10, truckWeights));
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int totalTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        int currentWeight = 0;

        int idx = 0;
        boolean full = false;
        while(true) {
            while (idx < truckWeights.length &&
                    currentWeight + truckWeights[idx] <= weight && queue.size() <= bridgeLength) {
                queue.add(truckWeights[idx]);
                currentWeight += truckWeights[idx];
                idx++;
                full = true;
            }
            if(full) {
                totalTime += bridgeLength - queue.size();
            }

            if(queue.isEmpty()) {
                break;
            }

            totalTime ++;
            currentWeight -= queue.poll();
            full = false;
        }

        return totalTime + 1;
    }
}
