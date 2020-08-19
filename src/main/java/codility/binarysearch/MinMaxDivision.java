package codility.binarysearch;

/**
 * https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 *
 * not solved
 */
public class MinMaxDivision {
    public static void main(String[] args) {
//        int[] A = {2, 1, 5, 1, 2, 2, 2};
//        int[] A = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] A = {4, 1, 2, 7};
        MinMaxDivision fn = new MinMaxDivision();
        System.out.println(fn.solution(2, 7, A));
    }

    public int solution(int K, int M, int[] A) {
        int[] bucket = new int[K];
        int bucketSize = (int) Math.ceil(A.length / (double)K);
        int standard = bucketSize * M / 2;

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            boolean inserted = false;

            for (int j = 0; j < bucket.length; j++) {
                if(!inserted && A[i] + bucket[j] < standard) {
                    bucket[j] += A[i];
                    inserted = true;
                }
                max = Math.max(max, bucket[j]);
            }

            if(!inserted) {
                standard = M * bucketSize + 1;
                i = -1;
            }
        }

        return max;
    }
}
