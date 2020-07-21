package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/1978
 *
 * - 2 ~ n-1 사이에 나누어 떨어지는 수가 있으면 소수가 아님
 *   - 2 ~ n/2 까지 나누어 떨어지는 수가 있으면 소수가 아님
 *      - 곱하는 최소값이 2이기 때문
 *      - n/2+1 ~ n-1 사이에는 약수가 있을 수 없음
 *   - 이렇게 범위를 줄여도 결국 O(n) 이라, 속도 차이가 그렇게 크게 나지 않음
 *
 * - n = a * b
 *   - a <= sqrt(n), b >= sqrt(n)
 *   - a 에 해당하는 b 의 짝이 있어야 n 이 나올 수 있으므로, a 에 대해서만 나누어 떨어지는지 검사하면 된다
 *   - 시간복잡도 O(sqrt(n))
 */
public class 소수_찾기 {
    public int count(int... numbers) {
        int count = 0;
        for (int value : numbers) {
            if(isPrimeNumber(value)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int number) {
        if(number == 1) {
            return false;
        }

        // 실수는 근사값이므로 사용하지 않는것이 좋다(a <= sqrt(number) -> a * a <= number)
        for (int i = 2; i * i <= number; i++) { // 2 부터 시작해서 가장 작은 a 값을 구하는 과정
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
