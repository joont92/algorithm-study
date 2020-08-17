package codility.sorting;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 *
 * 이미 정렬이 되었기 떄문에 3가지 조건을 모두 검사할 필요없이 앞의 두 숫자의 합이 세번쨰 숫자보다 큰지만 검사하면 된다
 * 배열 요소의 범위가 Integer.MAX_VALUE 까지 이므로 단순히 더하면 overflow 가 발생하므로, 수식을 조금 바꿔준다
 */
public class Triangle {
    public static void main(String[] args) {
        int[] A = {2_147_483_644, 2_147_483_645, 2_147_483_646, 2_147_483_647};
//        int[] A = {10, 2, 5, 1, 8, 20};
        Triangle fn = new Triangle();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if(A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }

        return 0;
    }
}
