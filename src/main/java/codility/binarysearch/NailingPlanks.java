package codility.binarysearch;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
 *
 * not solved
 */
public class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        int i = 0;
        int j = 0;
        for (; i < A.length; i++) {
            while (j < C.length) {
                if(A[i] <= C[j] && B[i] >= C[j]) {
                    j++;
                } else {
                    break;
                }
            }
        }

        return 0;
    }
}
