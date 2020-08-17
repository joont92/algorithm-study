package codility.dynamicprogramming;

/**
 * https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 *
 * 백준 "가장 긴 증가하는 부분 수열"과 비슷한 유형의 문
 * 첫번째 배열부터 돌면서,
 */
public class NumberSolitaire {
    public static void main(String[] args) {
//        int[] A = {1, -2, 0, 9, -1, -2};
        int[] A = {-1, 9, -2, -1, -2, -1, -2, -7, 5, 4}; // 9와 5사이에 6칸 이상
//        int[] A = {0, -4, -5, -2, -7, -9, -3, -10};
        NumberSolitaire fn = new NumberSolitaire();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        int[] result = new int[A.length];

        result[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            result[i] = Integer.MIN_VALUE;

            int endIdx = Math.max(i - 6, 0);
            for (int j = i - 1; j >= endIdx; j--) {
                result[i] = Math.max(result[i], result[j] + A[i]);
            }
        }

        return result[result.length - 1];
    }
}
