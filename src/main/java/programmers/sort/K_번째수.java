package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K_번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        K_번째수 fn = new K_번째수();
        for (int i : fn.solution(array, commands)) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            answer.add(subArray[command[2] - 1]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
