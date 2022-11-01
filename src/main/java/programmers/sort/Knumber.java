package programmers.sort;

import java.util.Arrays;

public class Knumber {
    public static void main(String[] args) {
        Arrays.stream(
            new Knumber().solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{
                    {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
                }
            )
        ).forEach(System.out::println);
    }

    public int[] solution(int[] array, int[][] commands) {
        var result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            var subArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(subArray);

            result[i] = subArray[commands[i][2] - 1];
        }

        return result;
    }

    // 배열 복사 직접 구현
}
