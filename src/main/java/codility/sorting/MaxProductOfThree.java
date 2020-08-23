package codility.sorting;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 *
 * 음수 2개를 곱하면 양수가 되기 때문에, 단순히 맨 마지막 3개를 곱해선 안됨
 * max(앞의 음수 2개 * 마지막 숫자, 마지막 숫자 3개) 를 구하면 된다
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = {-5, 5, -5, 4};
        MaxProductOfThree fn = new MaxProductOfThree();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int idx = A.length - 1;

        int max = A[idx] * A[idx - 1] * A[idx - 2];
        if(A[0] < 0 && A[1] < 0) {
            max = Math.max(max, A[0] * A[1] * A[idx]);
        }

        return max;
    }
}
