package codility.dynamicprogramming;

/**
 * https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 *
 * 백준 "가장 긴 증가하는 부분 수열"과 비슷한 유형의 문제
 * 자기 자신과 앞의 배열들의 합 중 더 큰 숫자를 선택한다
 * 여기서 주의해야 할 점은, **아무것도 선택하지 않고 자기 자신을 바로 선택할 수 없다**는 점이다
 * 이는 2가지 경우의 수에 모두 적용된다
 * - index가 6 이하일 경우, 무조건 0번째 인덱스를 선택하고 와야함
 * - index가 6 초과일 경우, 이전 6개 내에 무조건 1개를 선택하고 와야함
 *
 * 6이하, 6초과를 나눠서 분기 태울수도 있지만..
 * 사실상 초기값을 Integer.MIN_VALUE 로 설정하면 모든게 해결된다
 * MIN_VALUE 이기 때문에 무조건 다른 변수와 더하고 와야하기 때문이다
 */
public class NumberSolitaire {
    public static void main(String[] args) {
//        int[] A = {1, -2, 0, 9, -1, -2};
        int[] A = {0, -4, -5, -2, -7, -9, -3, -10};
//        int[] A = {-5, -2, 0, 9, -1, -2, 3, 4, 7};
//        int[] A = {-1, 9, -2, -1, -2, -1, -2, -7, 5, 4}; // 9와 5사이에 6칸 이상
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

    public int solution2(int[] A) {
        int[] dp = new int[A.length];

        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if(i <= 6) {
                dp[i] = A[i];

                int end = Math.max(i - 6, 1);
                for (int j = i - 1; j >= end; j--) {
                    dp[i] = Math.max(dp[i], A[i] + dp[j] - A[0]);
                }
                dp[i] += A[0];
            } else {
                dp[i] = Integer.MIN_VALUE;

                int end = Math.max(i - 6, 0);
                for (int j = i - 1; j >= end; j--) {
                    dp[i] = Math.max(dp[i], A[i] + dp[j]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
