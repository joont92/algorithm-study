package codility.timecomplexity;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 *
 * 마지막 숫자가 전달되지 않는 경우 주의!
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6, 4, 2};
        PermMissingElem fn = new PermMissingElem();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
