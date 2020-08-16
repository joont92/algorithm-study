package codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class _02_CyclicRotation {
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        _02_CyclicRotation fn = new _02_CyclicRotation();
        Arrays.stream(fn.solution(A, 3)).forEach(System.out::println);
    }

    public int[] solution(int[] A, int K) {
        int[] answer = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            answer[(i + K) % A.length] = A[i];
        }

        return answer;
    }
}
