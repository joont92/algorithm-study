package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};

        다리를_지나는_트럭 fn = new 다리를_지나는_트럭();
        System.out.println(fn.solution(100, 100, truckWeights));
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int[] bridge = new int[bridgeLength];
        Queue<Integer> trucks = Arrays.stream(truckWeights)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int time = 0;
        while(!trucks.isEmpty()) {
            int startIdx = 0;
            if(Arrays.stream(bridge).sum() + trucks.peek() <= weight && bridge[0] == 0) {
                bridge[0] = trucks.poll();
                startIdx = 1;
            }

            if(trucks.isEmpty()) {
                for (int i = 0; i < bridge.length; i++) {
                    if(bridge[i] > 0) {
                        time += bridgeLength - i;
                    }
                }
                break;
            }

            for (int i = startIdx; i < bridge.length; i++) {
                if(bridge[i] > 0) {
                    if(i < bridge.length - 1) {
                        bridge[i + 1] = bridge[i];
                    }

                    bridge[i] = 0;
                }
            }
            time++;
        }

        return time;
    }
}
