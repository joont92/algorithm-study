package baekjoon.math;

/**
 * https://www.acmicpc.net/problem/9613
 */
public class GCD_합 {
    public int sumOfGcds(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum += gcd(numbers[i], numbers[j]);
            }
        }

        return sum;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
