package codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 *
 * 첫번쨰 part에 대해서 왼쪽 합, 오른쪽 합을 먼저 구하고
 * 그 다음 part 부터는 왼쪽의 합 + part, 오른쪽 합 - part 로 진행하면 된다
 */
public class _03_TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = {3, 1};

        _03_TapeEquilibrium fn = new _03_TapeEquilibrium();
        System.out.println(fn.solution(A));
    }

    public int solution(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if(i == 1) {
                left[i] = A[i - 1];
                for (int j = 1; j < A.length; j++) {
                    right[i] += A[j];
                }
            } else {
                left[i] = left[i - 1] + A[i - 1];
                right[i] = right[i - 1] - A[i - 1];
            }

            min = Math.min(min, Math.abs(left[i] - right[i]));
        }

        return min;
    }
}
